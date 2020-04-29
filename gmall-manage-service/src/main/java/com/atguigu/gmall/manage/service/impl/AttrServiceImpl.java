package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.manage.mapper.AttrInfoMapper;
import com.atguigu.gmall.manage.mapper.AttrInfoMapperValue;
import com.atguigu.gmall.service.catalog.AttrService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: gmall0105
 * @description: [用一句话描述此类]
 * @author: Tiannan.Lu
 * @create: 2020-04-27 17:46
 **/
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    AttrInfoMapper attrInfoMapper;

    @Autowired
    AttrInfoMapperValue attrInfoMapperValue;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        Example example = new Example(PmsBaseAttrInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catalog3Id", catalog3Id);
        return attrInfoMapper.selectByExample(example);
    }

    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
//分两步保存，第一步保存属性（会有主键返回的），第二步保存属性值
        //1.insert,不管你字段有没有值，都插入数据库
        //2.insertSelective 空值的字段不插入数据库
        //插入的时候会返回主键，自动setd到pmsBaseAttrInfo的id字段里面，不需要我们手动设置，但是需要在实体类种设置主键返
        attrInfoMapper.insertSelective(pmsBaseAttrInfo);

        //保存属性值
        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
        for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
            //得到属性的主键，设置进去
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            attrInfoMapperValue.insertSelective(pmsBaseAttrValue);
        }
        return "Success";
    }
}

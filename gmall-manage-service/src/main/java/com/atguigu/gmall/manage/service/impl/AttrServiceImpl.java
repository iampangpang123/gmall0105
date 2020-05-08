package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;
import com.atguigu.gmall.manage.mapper.AttrInfoMapper;
import com.atguigu.gmall.manage.mapper.AttrInfoMapperValue;
import com.atguigu.gmall.manage.mapper.BaseSaleAttrMapper;
import com.atguigu.gmall.service.catalog.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: gmall0105
 * @description: (操作平台属性的业务类]
 * @author: Tiannan.Lu
 * @create: 2020-04-27 17:46
 **/
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    AttrInfoMapper attrInfoMapper;

    @Autowired
    AttrInfoMapperValue attrInfoMapperValue;

    @Autowired
    BaseSaleAttrMapper baseSaleAttrMapper;

    @Override
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id) {
        //根据example对象查
        Example example = new Example(PmsBaseAttrInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catalog3Id", catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos = attrInfoMapper.selectByExample(example);
        for (PmsBaseAttrInfo pmsBaseAttrInfo : pmsBaseAttrInfos) {
            //直接new对象查
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            List<PmsBaseAttrValue> attrInfoValues = attrInfoMapperValue.select(pmsBaseAttrValue);
            pmsBaseAttrInfo.setAttrValueList(attrInfoValues);
        }
        return pmsBaseAttrInfos;
    }

    /**
     * 保存修改可以合并到这一个方法里面，
     * 因为主键是自增的，保存的时候pmsBaseAttrInfo的Id属性没有值，修改的时候是有值的
     * 可以根据Id是否为空，判断是增加还是修改
     * 注意:保存的前缀一定要统一，最后写insert，后面我会根据方法名，添加事务，这里我写的save懒得改了。
     *
     * @param pmsBaseAttrInfo
     * @return
     */
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        if (StringUtils.isBlank(pmsBaseAttrInfo.getId())) {
            //分两步保存，第一步保存属性（会有主键返回的），第二步保存属性值
            //1.insert,不管你字段有没有值，都插入数据库
            //2.insertSelective 空值的字段不插入数据库
            //插入的时候会返回主键，自动set到pmsBaseAttrInfo的id字段里面，不需要我们手动设置，但是需要在实体类种设置主键返
            attrInfoMapper.insertSelective(pmsBaseAttrInfo);

            //保存属性值
            List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
                //得到属性的主键，设置进去
                pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
                attrInfoMapperValue.insertSelective(pmsBaseAttrValue);
            }
            return "Success";
        } else {
            //我下面代码是正常修改，你也可以根据属性ID直接把这些pmsBaseAttrValue删除掉重新插入，但是我不建议这样做，虽然方便，但是危险
            //1.修改属性
            Example example = new Example(PmsBaseAttrInfo.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id", pmsBaseAttrInfo.getId());
            //第一个是要更新的对象，第二参数是更新的条件
            attrInfoMapper.updateByExampleSelective(pmsBaseAttrInfo, example);
            //2.修改属性值
            for (PmsBaseAttrValue pmsBaseAttrValue : pmsBaseAttrInfo.getAttrValueList()) {
                Example example2 = new Example(PmsBaseAttrValue.class);
                Example.Criteria criteria2 = example.createCriteria();
                criteria.andEqualTo("id", pmsBaseAttrValue.getId());
                attrInfoMapperValue.updateByExampleSelective(pmsBaseAttrValue, example2);
            }

        }
        return "Success";

    }


    public List<PmsBaseSaleAttr> baseAttrValueList() {

        return baseSaleAttrMapper.selectAll();

    }
}

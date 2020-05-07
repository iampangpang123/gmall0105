package com.atguigu.gmall.service.catalog;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * @program: gmall0105
 * @description: [用一句话描述此类]
 * @author: Tiannan.Lu
 * @create: 2020-04-27 17:45
 **/
public interface AttrService {

    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    /*
     **
     * [保存平台属性：比如：内存{128g,256g，512g}这样的格式的，需要保存在两个表里面
     * pms_attr_info 和pms_attr_value两个表，记得参数里面是没有 pms_attr_info的id的，需要主键返回
     ]
     * @author ttao
     * @param
     * @return   保存结果（是否失败)
     */
    String  saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);


    /**
     * 查询所有的销售属性，销售属性是平台数据字典定义的，也就是商城的后台管理种，管理员添加平台属性
     * 销售属性的值 可以让商家定义
     * @return
     */
    public  List<PmsBaseSaleAttr> baseAttrValueList();
}

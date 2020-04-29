package com.atguigu.gmall.service.catalog;

import com.atguigu.gmall.bean.PmsBaseAttrInfo;

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
}

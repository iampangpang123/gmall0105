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
}

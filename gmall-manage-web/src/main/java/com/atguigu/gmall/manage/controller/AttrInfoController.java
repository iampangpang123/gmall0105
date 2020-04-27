package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.service.catalog.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: gmall0105
 * @description: [用一句话描述此类]
 * @author: Tiannan.Lu
 * @create: 2020-04-27 17:49
 **/
@Controller
@CrossOrigin(value = "*",maxAge = 3600)
public class AttrInfoController {

    @Reference
    AttrService attrService;

    @ResponseBody
    @RequestMapping(value = "/attrInfoList",method = {RequestMethod.GET,RequestMethod.POST})
    public List<PmsBaseAttrInfo> attrInfoList(String catalog3Id){

        return  attrService.attrInfoList(catalog3Id);
    }
}

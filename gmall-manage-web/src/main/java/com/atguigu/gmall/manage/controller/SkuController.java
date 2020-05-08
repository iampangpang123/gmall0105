package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.service.sku.SkuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: gmall0105
 * @description: [用一句话描述此类]
 * @author: Tiannan.Lu
 * @create: 2020-05-08 14:28
 **/
@Controller
@CrossOrigin
public class SkuController {

    @Reference
    SkuService skuService;


    @RequestMapping("saveSkuInfo")
    @ResponseBody
    public void saveSkuInfo(@RequestBody PmsSkuInfo pmsSkuInfo) {
        skuService.saveSkuInfo(pmsSkuInfo);

    }
}

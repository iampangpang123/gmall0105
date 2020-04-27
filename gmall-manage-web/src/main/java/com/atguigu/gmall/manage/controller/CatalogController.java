package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
跨域注解@CrossOrigin
origin="*"代表所有域名都可访问
maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class CatalogController {
    @Reference
    CatalogService catalogService;

    @ResponseBody
    @RequestMapping(value = "/getCatalog1", method = {RequestMethod.GET, RequestMethod.POST})
    public List<PmsBaseCatalog1> getAllCatalog1() {
        return catalogService.getAllCatalog1();
    }

    @ResponseBody
    @RequestMapping(value = "/getCatalog2", method = {RequestMethod.GET, RequestMethod.POST})
    public List<PmsBaseCatalog2> getAllCatalog2(String catalog1Id) {
        return catalogService.getAllCatalog2(catalog1Id);
    }

    @ResponseBody
    @RequestMapping(value = "/getCatalog3", method = {RequestMethod.GET, RequestMethod.POST})
    public List<PmsBaseCatalog3> getAllCatalog3(String catalog2Id) {
        return catalogService.getAllCatalog3(catalog2Id);
    }

}

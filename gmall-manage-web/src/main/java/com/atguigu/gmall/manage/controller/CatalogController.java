package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.service.catalog.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CatalogController {
    @Reference
    CatalogService catalogService;

  @ResponseBody
   @RequestMapping(value = "/getCatalog1",method = {RequestMethod.GET,RequestMethod.POST})
    public List<PmsBaseCatalog1> getAllCatalog1() { return catalogService.getAllCatalog1(); }
}

package com.atguigu.gmall.item.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.service.sku.SkuService;
import com.atguigu.gmall.service.spu.SpuService;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: gmall0105
 * @description: [用一句话描述此类]
 * @author: Tiannan.Lu
 * @create: 2020-05-08 19:59
 **/
@Controller
@CrossOrigin
public class ItemController {

    public static final Logger LOG = LoggerFactory.getLogger(ItemController.class);

    @Reference
    SkuService skuService;


    @RequestMapping("{skuId}.html")
    //这样就可以满足商品详情页的地址的风格是下面的这种
    //https://item.jd.com/66762032452.html
    //又是因为请求类型是restful风格的，所以用注解@PathVariable，@PathVariable注解不限制请求类型
    //注意：@PathVariable主要用于接收http://host:port/path/{参数值}数据。@RequestParam主要用于接收http://host:port/path?参数名=参数值数据，这里后面也可以不跟参数值。
    public String item(@PathVariable String skuId, ModelMap modelMap) {
//ModelMap对象的 addAttribute,put两个方法区别是: addAttribute是不允许添加空值的key，put是允许的
        PmsSkuInfo skuInfo = skuService.getSkuById(skuId);
        modelMap.put("skuInfo", skuInfo);
        return "item";
    }


    @RequestMapping("indexhello")
    @ResponseBody
    public String indexhello() {
        LOG.error("Error:index、index、index");
        LOG.warn("warn:index、index、index");
        LOG.info("info:index、index、index");
        LOG.debug("debug:index、index、index");
        return "indexhello";
    }

    @RequestMapping("index")
    public ModelAndView index(ModelAndView modelAndView) {
        Map map = new HashMap();
        map.put("hello", "hello:打地值已经修改");
        List list = new ArrayList<String>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        map.put("list", list);
        map.put("check", 1);
        modelAndView.addAllObjects(map);
        return modelAndView;
    }

}

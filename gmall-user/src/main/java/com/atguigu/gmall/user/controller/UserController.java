package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello() {
        //一会用来测试lombok插件用
        UmsMember umsMember=new UmsMember();
        umsMember.setUsername("1111");//lombok插件安装完成
       // return userService.hello();
        return "按适用税率征税销售额（3>=4+5+6)";
    }

    @ResponseBody
    @GetMapping(value = "/getAllUser")
    public List<UmsMember> getAllUser() {
        //这是我们自己写的单表增删改查，我们注释掉，测试通用mapper为我们提供的增删改
       return userService.getAllUser();

    }
    @ResponseBody
    @GetMapping(value = "/getAllUserMap")
    public List<Map<String, Object>> getAllUserMap() {
        //这是我们自己写的单表增删改查，我们注释掉，测试通用mapper为我们提供的增删改
        return userService.getAllUserMap();
    }

    @ResponseBody
    @GetMapping(value = "/getAllUserByID")
    public List<UmsMemberReceiveAddress> getAllUserByUID() {
        //这是我们自己写的单表增删改查，我们注释掉，测试通用mapper为我们提供的增删改
        return userService.getReceiveAddressByUserID();

    }

    @ResponseBody
    @GetMapping(value = "/getMap")
    public List<Map<String,String>> getMap() {

        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        Map map1=new HashMap<String,String>();
        map1.put("xzqhDm","111111");
        map1.put("xzqhMc","张三");
        Map map2=new HashMap<String,String>();
        map2.put("xzqhDM","222222");
        map2.put("xzqhMc","李四");
        Map map3=new HashMap<String,String>();
        map3.put("XZQHDM","333333");
        map3.put("xzqhMc","王五");
        list.add(map1);
        list.add(map2);
        list.add(map3);
        return  list;
    }

}

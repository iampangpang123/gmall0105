package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
   // @Autowired   同一个容器才能用自动注入，现在我门需要referce才能注入（导入dubbo的）
    @Reference
    UserService userService;


    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello() {
        //一会用来测试lombok插件用
        UmsMember umsMember=new UmsMember();
        umsMember.setUsername("1111");//lombok插件安装完成
        return userService.hello();
    }

    @ResponseBody
    @GetMapping(value = "/getAllUser")
    public List<UmsMember> getAllUser() {
        //这是我们自己写的单表增删改查，我们注释掉，测试通用mapper为我们提供的增删改
       return userService.getAllUser();

    }

    @ResponseBody
    @GetMapping(value = "/getAllUserByID")
    public List<UmsMemberReceiveAddress> getAllUserByUID() {
        //这是我们自己写的单表增删改查，我们注释掉，测试通用mapper为我们提供的增删改
        return userService.getReceiveAddressByUserID();

    }

}

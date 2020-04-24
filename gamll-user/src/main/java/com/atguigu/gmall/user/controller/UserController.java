package com.atguigu.gmall.user.controller;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserService userService;


    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello() {
        return userService.hello();
    }

    @ResponseBody
    @GetMapping(value = "/getAllUser")
    public List<UmsMember> getAllUser() {
        return userService.getAllUser();
    }

}

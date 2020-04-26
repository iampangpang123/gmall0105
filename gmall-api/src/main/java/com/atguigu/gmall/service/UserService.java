package com.atguigu.gmall.service;


import com.atguigu.gmall.bean.UmsMember;
import com.atguigu.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {



    public  String hello();
    public List<UmsMember> getAllUser();


    public List<UmsMemberReceiveAddress> getReceiveAddressByUserID();
}

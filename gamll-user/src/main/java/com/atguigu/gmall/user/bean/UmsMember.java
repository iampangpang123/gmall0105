package com.atguigu.gmall.user.bean;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class UmsMember {
    //因为通用的mapper为我们提供增删改没有主键返回（如果数据库里面的主键是自增的话），需要我们配置
    //id标识代表这个是主键
    // @GeneratedValue(strategy = GenerationType.IDENTITY)代表主键返回政策是主键自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String memberLevelId;//这个字段数据库是int类型，因为mysql会自动帮我门转换
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private int status;
    private Date createTime;
    private String icon;
    private int gender;
    private Date birthday;
    private String city;
    private String job;
    private String personalizedSignature;
    private int sourceType;
    private int integration;
    private int growth;
    private int luckeyCount;
    private int historyIntegration;


}

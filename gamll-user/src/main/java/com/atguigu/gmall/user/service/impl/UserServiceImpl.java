package com.atguigu.gmall.user.service.impl;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.UmsMemberReceiveAddress;
import com.atguigu.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.atguigu.gmall.user.mapper.UserMapper;
import com.atguigu.gmall.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public String hello() {
        return "hello";
    }

    public List<UmsMember> getAllUser() {
        //这是我们自己写的单表增删改查，我们注释掉，测试通用mapper为我们提供的增删改
        return userMapper.getAllUser();


    }

    /**
     * @return 使用通用的Mapper实现单表增删改(不用逆向工程了 ， 逆向工程没这个通用Mapper接口好用还要拖文件xxxxMapper.xml)
     */
    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByUserID() {
        //因为是外键，所以我们用selectByExample,但是如果我们是实体类当查询条件，不能使用selectByExample
        //你set几个属性，sql加几个where条件
        //返回的是这个表的所有字段
//        UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
//        umsMemberReceiveAddress.setMemberId("1");
//        return  umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        ////////////////////////////////////上面是使用实体类进项查询////////////////////////////////////////////////
        /*
        使用example实现单表的增删改，建议你用select，简单点，但是多个条件的时候，用select你需要new 实体类一点点的set属性，麻烦
        不会写的话看这个博客：https://blog.csdn.net/biandous/article/details/65630783?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1
         */
        Example example = new Example(UmsMemberReceiveAddress.class);
        //memberId是表字段对应的实体类
        //createCriteria就相当于再where后面添加条件
        example.createCriteria().andEqualTo("memberId", "1");
        return umsMemberReceiveAddressMapper.selectByExample(example);
    }


}

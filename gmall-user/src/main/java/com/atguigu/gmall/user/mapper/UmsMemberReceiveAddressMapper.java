package com.atguigu.gmall.user.mapper;


import com.atguigu.gmall.bean.UmsMemberReceiveAddress;
import tk.mybatis.mapper.common.Mapper;
//UmsMemberReceiveAddress这个泛型就是逆向工程单表查询返回的泛型
public interface UmsMemberReceiveAddressMapper extends Mapper<UmsMemberReceiveAddress> {
}

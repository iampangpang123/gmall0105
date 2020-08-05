package com.atguigu.gmall.user.mapper;



import com.atguigu.gmall.bean.UmsMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/*要继承 tk.mybatis.mapper.common.Mapper才能实现单表查询不写sql
* 我们在UserServiceImpl里面直接声明UserMapper UserMapper
* 就可以调取对应方法，idea会提示的
* 缺点：1.没有主键返回，Bean实体类想要用需要配置，UmsMember里面配置@id注解和 @GeneratedValue(strategy = GenerationType.IDENTITY)
*      2.配置启动类扫描MapperScan使用通用mapper的扫描器，tk开头的,配置了这个，我们也不用在每个mapper接口上加@mapper注解了
*
*
* */
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<UmsMember> {

    List<UmsMember> getAllUser();

    List<Map<String,Object>> getAllUserMap();

    Map  getOneMapUSer();
}

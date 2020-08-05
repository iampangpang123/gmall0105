package com.atguigu.gmall.user;

import com.atguigu.gmall.user.GamllUserApplication;
import com.atguigu.gmall.user.mapper.UserMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/*
https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4
MOCK —提供一个Mock的Servlet环境，内置的Servlet容器并没有真实的启动，主要搭配使用@AutoConfigureMockMvc

RANDOM_PORT — 提供一个真实的Servlet环境，也就是说会启动内置容器，然后使用的是随机端口
DEFINED_PORT — 这个配置也是提供一个真实的Servlet环境，使用的默认的端口，如果没有配置就是8080
NONE — 这是个神奇的配置，跟Mock一样也不提供真实的Servlet环境。
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GamllUserApplication.class)
public class GamllUserApplicationTests {

@Autowired
    UserMapper userMapper;


    @Test
    public void testBookService() {
        Map oneMapUSer = userMapper.getOneMapUSer();
        System.out.println(oneMapUSer);
    }


}


# gmall项目配置以及相关文档
#1.常用命令
netstat -ant|grep 8180  查看端口号是否占用  
netstat -ant|grep 8180  查看端口号是否占用  
chmod 777 后面接文件 解决权限不够的问题  
dhclient  刷新网络  

#2.虚拟机       
###1.gmall_01    192.168.25.128（虚拟机改成25网段，不然用不了FastDFS，当时配置的网段是25，）  
   >账号：root   密码：123456  
>1.1:Dubbo
>                      
    软件位置：root/apache-tomcat-7.0.47  
    端口号：8080  
    访问地址：http://192.168.25.128:8080/dubbo-admin-2.5.4/  
    账号：root   密码：root  
    注意：需要先启动Zookeeper  
>1.2:zookeeper 
> 
     ip:192.168.25.128
     端口号：2181  
     启动：./zkServer start  
     关闭：./zkServer stop  
     查询启动状态：./zkServer status  



###2.gmall_02    192.168.1.173  
  >账号：root     密码：123456  


###3.gmall-image-server    192.168.25.133  
  >1.账号：root     密码：itcast  
  >2.图片服务器测试地址：  
  >>http://192.168.25.133/group1/M00/00/00/wKgZhV6zb2aAWjJjAACLKjl6Sog589.jpg



 


#3.服务端口号+启动顺序

###1.gmall-user-service     127.0.0.1：8070     2
 >
###2.gmall-user-web         127.0.0.1：8080     1
 >
###3.gmall-manage-service   127.0.0.1：8071     1
 >  
###4.gmall-manage-web       127.0.0.1：8081     2
 >  
###5.gmall-admin            127.0.0.1:8888     0
 >>前端后端管理项目:调取得后端得接口地址：gmall-manage-web   127.0.0.1：8081
  如果启动失败，顺序执行下面两个命令   
 >>npm uninstall --save node-sass      
 >>npm install   --save node-sass  
 >>由于前后端分离，前后端端口不一致产生了跨域问题，解决方案：
 >>>1.Nginx    我们后面再配置（现在暂时用@CrossOrigin解决一下）  
 >>>2.jsonp  
 >>>3.跨域注解（@CrossOrigin，加在controller类上）  
 >>>4.继承WebMvcConfigurerAdapter重写addCorsMappings（）,原理跟3是一样的，只不过这种方法是全局配置

   
##注意
>1.Controller
>>1.1:controller我们需要加@CrossOrigin
>>1.2:Controller引用service，不要用@Autowire注解，要用Alibaba的@Reference注解  
>2.Service
>>2.1:Service的实现类一定的@Service注解一定要是Alibaba的@service注解而不是spring的




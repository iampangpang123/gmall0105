# gmall项目配置以及相关文档
#1.常用命令
netstat -ant|grep 8180  查看端口号是否占用  
netstat -ant|grep 8180  查看端口号是否占用  
chmod 777 后面接文件 解决权限不够的问题  
dhclient  刷新网络  

#2.虚拟机
###1.gmall_01    192.168.81.128（后面我搭建图片上传服务器，我可能会给网段改成25，，那么ip为：192.168.25.128）  
   >账号：root   密码：123456  
>1.1:Dubbo
>                      
       软件位置：root/apache-tomcat-7.0.47  
       端口号：8080  
       访问地址：http://192.168.81.128:8080/dubbo-admin-2.5.4/  
       账号：root   密码：root  
       注意：需要先启动Zookeeper  
>1.2:zookeeper 
> 
     端口号：2181  
     启动：./zkServer start  
     关闭：./zkServer stop  
     查询启动状态：./zkServer status  



###2.gmall_02    192.168.1.173  
  >账号：root     密码：123456
 


#3.服务端口号

###1.gmall-user-service     192.168.84.128：8070  
 >
###2.gmall-user-web         192.168.84.128：8080   
 >
###3.gmall-manage-service   192.168.84.128：8071
 > 
###4.gmall-manage-web       192.168.84.128： 8081
 >  
###5.gmall-admin              127.0.0.1:8888
 >前端项目:后端得接口地址：gmall-manage-web   192.168.84.128：8081
  如果启动失败，顺序执行下面两个命令   
 >>npm uninstall --save node-sass      
 >>npm install   --save node-sass

   



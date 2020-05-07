package com.atguigu.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.service.spu.SpuService;
import common.util.FastDFSClient;
import common.util.JsonUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: gmall0105
 * @description: [spu]
 * @author: Tiannan.Lu
 * @create: 2020-04-30 14:06
 **/
@Controller
@CrossOrigin
public class SpuController {
//    public static  final Logger Logger= LoggerFactory.getLogger(SpuController.class);


    @Value("${IMAGE_SERVER_URL}")
    public String IMAGE_SERVER_URL;
    /**
     * 调取这个服务有三种方式
     * 1.你把你服务发布到公司的注册中心上，但是一般不让你发
     * 2.注册中心地址用的是公司的服务器的，缺点：动了service代码需要更新服务器的代码，重新打包升级，比较玛法
     */
    @Reference
    SpuService spuService;


    /**
     * 得到spu列表
     *
     * @param catalog3Id
     * @return
     */
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id) {
        return spuService.spuList(catalog3Id);
    }

    /*
      保存spu
     */
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public void saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo) {


        System.out.println("aaaaaaaaaaaaaaaaaaaa");
    }


    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile MultipartFile) {

            /*
        图片上传服务器暂时没有开启，我们先随便返回一个本机地址
         */
        //  return "C:\\Users\\92397\\Pictures\\Saved Pictures\\6626003a708ce8ef.jpg";
        try {
            //把图片上传的图片服务器
            System.out.println(this.getClass().getClassLoader().getResourceAsStream("client.conf"));//我不知道为什么，这里打印的是我jdk的路径(/G:/JavaEE/JDK8/jdk/)

            //这个路径是对的：G:\JavaEE\Idea\workspace\gmall0105\gmall-manage-web\target\classes\client.conf
            String path = new ClassPathResource("client.conf").getFile().getPath();
            FastDFSClient fastDFSClient = new FastDFSClient(path);
            //取文件名
            String originalFilename = MultipartFile.getOriginalFilename();
            //根据文件名得到文件扩展名
            String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            //得到一个图片的地址和文件名
            String url = fastDFSClient.uploadFile(MultipartFile.getBytes(), extName);
            //补充为完整的url
            url = IMAGE_SERVER_URL + url;
            return url;
        } catch (Exception e) {
            System.out.println("上传到FASTDFS失败！");
            System.out.println(e.getMessage());
            return "上传失败";
        }

    }

    @RequestMapping("manageWeb/hello")
    @ResponseBody
    public String manageWebHello() {
        return "manageWeb-hello";
    }
}

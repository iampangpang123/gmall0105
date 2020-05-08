package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsSkuAttrValue;
import com.atguigu.gmall.bean.PmsSkuImage;
import com.atguigu.gmall.bean.PmsSkuInfo;
import com.atguigu.gmall.bean.PmsSkuSaleAttrValue;
import com.atguigu.gmall.manage.mapper.*;
import com.atguigu.gmall.service.sku.SkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @program: gmall0105
 * @description: [用一句话描述此类]
 * @author: Tiannan.Lu
 * @create: 2020-05-08 14:37
 **/
@Service//注解一定要加alibaba得，再强调一遍，别加成spring的了，浪费时间
public class SkuServiceImpl implements SkuService {
    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;
    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;


    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        //这个属性是临时用的，用来代替，productId，因为前端写错了，封装不进来，只能用这个解决,得到值后再复制给ProductId
        String skuId = pmsSkuInfo.getSpuId();
        pmsSkuInfo.setProductId(skuId);
        //1.保存sku
        pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuInfoId = pmsSkuInfo.getId();//得到主键自增返回的id

        //2.保存sku的图片
        List<PmsSkuImage> pmsSkuImageList = pmsSkuInfo.getSkuImageList();
        //2.1:如果前台没提交默认图片，设置默认的图片
        if(StringUtils.isBlank(pmsSkuInfo.getSkuDefaultImg())){
            pmsSkuInfo.setSkuDefaultImg(pmsSkuImageList.get(0).getImgUrl());
        }
        //2.2：保存图片集合
        for (PmsSkuImage pmsSkuImage : pmsSkuImageList) {
            pmsSkuImage.setSkuId(skuInfoId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }
        //3.保存sku平台属性与值(平台属性关联)
        List<PmsSkuAttrValue> pmsSkuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : pmsSkuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuInfoId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        //4.保存sku销售属性与销售属性值（销售属性关联）
        List<PmsSkuSaleAttrValue> pmsSkuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : pmsSkuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuInfoId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

    }
}

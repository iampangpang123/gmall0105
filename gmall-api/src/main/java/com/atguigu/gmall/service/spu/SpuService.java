package com.atguigu.gmall.service.spu;

import com.atguigu.gmall.bean.PmsProductImage;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @program: gmall0105
 * @description: [用一句话描述此类]
 * @author: Tiannan.Lu
 * @create: 2020-04-30 14:07
 **/
public interface SpuService {

    /**
     * 查询的其实就是spu，也就是pms_product_info的商品表（不是一个具体的商品，是一个商品的系列，所以就是spu）
     * 虽然是spu，比如苹果x是spu，但是商品的基本属性你还是需要设置的。比如名称，图片，简介。描述之类的
     * @param catalog3Id
     * @return
     */

    List<PmsProductInfo> spuList(String catalog3Id);


    /**
     * 保存spu,添加一个spu，
     * @param pmsProductInfo
     */
    void saveSpuInfo(PmsProductInfo pmsProductInfo);



    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId );


    public List<PmsProductImage> spuImageList(String spuId);

}

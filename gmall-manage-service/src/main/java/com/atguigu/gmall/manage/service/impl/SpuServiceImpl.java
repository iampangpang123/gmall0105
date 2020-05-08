package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsProductImage;
import com.atguigu.gmall.bean.PmsProductInfo;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.bean.PmsProductSaleAttrValue;
import com.atguigu.gmall.manage.mapper.PmsProductImageMapper;
import com.atguigu.gmall.manage.mapper.PmsProductInfoMapper;
import com.atguigu.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.atguigu.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.atguigu.gmall.service.spu.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: gmall0105
 * @description: [操作spu的业务类]
 * @author: Tiannan.Lu
 * @create: 2020-04-30 14:11
 **/
@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;//商品销售属性
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;//商品销售属性值
    @Autowired
    PmsProductImageMapper pmsProductImageMapper; //商品图片


    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {
        Example example = new Example(PmsProductInfo.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catalog3Id", catalog3Id);
        List<PmsProductInfo> pmsProductInfos = pmsProductInfoMapper.selectByExample(example);
        return pmsProductInfos;
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {
        //1.保存商品得基本信息
        pmsProductInfoMapper.insertSelective(pmsProductInfo);
        //2.得到返回得主键
        String pmsProductInfoId = pmsProductInfo.getId();
        //3.保存商品图片
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(pmsProductInfoId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }
        //4.保存商品销售属性与销售属性值
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            //  4.1:保存商品销售属性
            pmsProductSaleAttr.setProductId(pmsProductInfoId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);
            String productSaleAttrId = pmsProductSaleAttr.getId();
            //4.2：保存商品销售属性值
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(pmsProductInfoId);//设置商品id
                pmsProductSaleAttrValue.setSaleAttrId(productSaleAttrId);//设置销售属性得id
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }

        }

    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {

        Example example=new Example(PmsProductSaleAttr.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("productId",spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.selectByExample(example);
        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        PmsProductImage pmsProductImage=new PmsProductImage();

        pmsProductImage.setProductId(spuId);

        List<PmsProductImage> pmsProductImages = pmsProductImageMapper.select(pmsProductImage);
        return pmsProductImages;
    }


}

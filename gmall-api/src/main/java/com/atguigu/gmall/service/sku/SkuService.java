package com.atguigu.gmall.service.sku;

import com.atguigu.gmall.bean.PmsSkuInfo;

/**
 * @program: gmall0105
 * @description: [用一句话描述此类]
 * @author: Tiannan.Lu
 * @create: 2020-05-07 19:32
 **/
public interface SkuService {
    /*
     **
     * [保存sku]
     * @param  pmsSkuInfo
     * @return
     */
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);

    /*
      根据skuid,得到商品信息
     */
    PmsSkuInfo getSkuById(String skuId);
}

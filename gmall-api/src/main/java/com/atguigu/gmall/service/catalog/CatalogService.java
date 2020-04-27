package com.atguigu.gmall.service.catalog;

import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;

import java.util.List;

public interface CatalogService {


    /**
     * @return
     */
    public List<PmsBaseCatalog1>  getAllCatalog1();

    public List<PmsBaseCatalog2>  getAllCatalog2(String catalog1Id);

    public List<PmsBaseCatalog3>  getAllCatalog3(String catalog2Id);
}

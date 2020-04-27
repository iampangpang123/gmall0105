package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.manage.mapper.Catalog1Mapper;

import com.atguigu.gmall.manage.mapper.Catalog2Mapper;
import com.atguigu.gmall.manage.mapper.Catalog3Mapper;
import com.atguigu.gmall.service.catalog.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    Catalog1Mapper catalog1Mapper;
    @Autowired
    Catalog2Mapper catalog2Mapper;
    @Autowired
    Catalog3Mapper catalog3Mapper;

    /**
     * 正常来说，一个mapper接口必须对应一个mapper.xml文件的，不然启动会报错
     * 但是我们用的是通用mapper，不写mapper.xml文件启动也不会报错
     */
    @Override
    public List<PmsBaseCatalog1> getAllCatalog1() {
        return catalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getAllCatalog2(String catalogId1) {
        Example example = new Example(PmsBaseCatalog2.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catalog1Id",catalogId1);
        return catalog2Mapper.selectByExample(example);
    }

    @Override
    public List<PmsBaseCatalog3> getAllCatalog3(String catalog2Id) {
        Example example = new Example(PmsBaseCatalog3.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("catalog2Id",catalog2Id);
        return catalog3Mapper.selectByExample(example);
    }
}

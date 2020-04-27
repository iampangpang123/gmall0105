package com.atguigu.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.manage.mapper.CatalogMapper;
import com.atguigu.gmall.service.catalog.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    CatalogMapper catalogMapper;

    /**正常来说，一个mapper接口必须对应一个mapper.xml文件的，不然启动会报错
     * 但是我们用的是通用mapper，不写mapper.xml文件启动也不会报错
     * @return
     */
    @Override
    public List<PmsBaseCatalog1> getAllCatalog1() {
       return  catalogMapper.selectAll();
    }
}

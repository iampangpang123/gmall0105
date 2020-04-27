package com.atguigu.gmall.bean;

import com.atguigu.gmall.bean.PmsBaseCatalog3;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @param
 * @return
 */
public class PmsBaseCatalog2 implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String name;
    @Column
    private String catalog1Id;

    /** @Transient  中文意思是游离的
     * 这个注解告诉mybatis这不是数据库的字段，在执行保存，插入的时候忽略这个字段
     */
    @Transient
    private List<PmsBaseCatalog3> catalog3List;

    public List<PmsBaseCatalog3> getCatalog3List() {
        return catalog3List;
    }

    public void setCatalog3List(List<PmsBaseCatalog3> catalog3List) {
        this.catalog3List = catalog3List;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatalog1Id() {
        return catalog1Id;
    }

    public void setCatalog1Id(String catalog1Id) {
        this.catalog1Id = catalog1Id;
    }
}

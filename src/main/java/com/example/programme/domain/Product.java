package com.example.programme.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:13
 * @description:
 */
public class Product {

    private Long id;
    private String name;
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

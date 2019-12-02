package com.example.programme.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/15 14:13
 * @description:
 */
@Data
public class Product {

    private Long id;
    private String name;
    private Date createTime;
}

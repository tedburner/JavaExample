package com.example.DesignPatterns.builder;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:27
 * @Description: 食物条目
 */
public interface Item {

    String name();
    Packing packing();
    float price();
}

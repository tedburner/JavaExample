package com.example.spring.bean;

import lombok.Data;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/10 14:09
 * @description:
 */
@Data
public class Person {

    private int id;
    private String name;
    private Integer age;

    public Person() {
        System.out.println("构造函数被调用");
    }

    public Person(int id, String name) {
        System.out.println("对bean设置属性值");
        this.id = id;
        this.name = name;
    }

    public void init() {
        System.out.println("init bean..");
    }
}
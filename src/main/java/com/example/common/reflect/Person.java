package com.example.common.reflect;

import java.io.Serializable;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 11:01
 * @description:
 */
public class Person implements Serializable {

    private Long id;
    private String name;

    static {
        System.out.println("测试反射静态代码块");
    }

    Person(Person person) {
        System.out.println("(默认)反射测试类构造了" + person);
    }

    public Person() {
        System.out.println("调用了公有、无参构造方法执行了。。。");
    }

    Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    Person(String name) {
        this.name = name;
        System.out.println("name+" + name);
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

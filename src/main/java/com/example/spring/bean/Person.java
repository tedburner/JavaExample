package com.example.spring.bean;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/10 14:09
 * @description:
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.example.common.jvm;

/**
 * @author: lingjun.jlj
 * @date: 2020/3/18 23:06
 * @description: 静态分派
 */
public class StaticDispatchCase {

    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human human) {
        System.out.println("Hi, guy!");
    }

    public void sayHello(Man man) {
        System.out.println("Hi, gentleman!");
    }

    public void sayHello(Woman woman) {
        System.out.println("Hi, lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatchCase sdc = new StaticDispatchCase();
        sdc.sayHello(man);
        sdc.sayHello(woman);
    }
}

package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2020/6/5 10:15
 * @description:
 */
public class SingletonDemo {

    //①
    //private static SingletonDemo instance = new SingletonDemo();

    private static int x = 0;
    private static int y;

    private SingletonDemo() {
        x++;
        y++;
    }

    //②
    private static SingletonDemo instance = new SingletonDemo();

    public static SingletonDemo getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingletonDemo singleton = SingletonDemo.getInstance();
        System.out.println(singleton.x);
        System.out.println(singleton.y);
    }
}

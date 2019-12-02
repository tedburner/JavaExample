package com.example.designpattern.MediatorPattern;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 21:35
 * @Description: 中介者模式
 * 用来降低多个对象和类之间的通信复杂性。这种模式提供了一个中介类，该类通常处理不同类之间的通信，并支持松耦合，使代码易于维护。
 * 中介者模式属于行为型模式。
 * 个人感觉有点类似中间件，大家通过中间件实现通信，降低了耦合性
 */
public class MediatorPattern {

    public static void main(String[] args) {

        User robert = new User("Robert");
        User john = new User("John");

        robert.sendMessage("Hi! John!");
        john.sendMessage("Hello! Robert!");
    }
}

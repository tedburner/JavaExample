package com.example.spring.aop.service;

/**
 * @author lingjun.jlj
 * @date: 2018/5/9
 * @Description:
 */
public class Person {

    public void sayHi() {
        try {
            Thread.currentThread().sleep(30);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hi!!");
    }

    public void sayBye() {
        try {
            Thread.currentThread().sleep(10);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("Bye!!");
    }
}

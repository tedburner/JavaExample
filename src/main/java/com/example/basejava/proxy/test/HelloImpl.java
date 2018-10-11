package com.example.basejava.proxy.test;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 13:48
 * @description:
 */
public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello Java!");
    }
}

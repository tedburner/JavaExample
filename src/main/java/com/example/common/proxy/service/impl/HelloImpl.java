package com.example.common.proxy.service.impl;

import com.example.common.proxy.service.Hello;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 13:48
 * @description:
 */
public class HelloImpl implements Hello {

    @Override
    public void sayHello() {
        System.out.println("Hello Hello!");
    }

    @Override
    public void sayJava() {
        System.out.println("Hello Java!");
    }

    @Override
    public void sayGo() {
        System.out.println("Hello Go!");
    }
}

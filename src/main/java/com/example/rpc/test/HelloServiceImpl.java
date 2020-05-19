package com.example.rpc.test;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-14 15:12
 * @description:
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}

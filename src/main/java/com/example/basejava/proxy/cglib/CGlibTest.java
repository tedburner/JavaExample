package com.example.basejava.proxy.cglib;

import com.example.basejava.proxy.cglib.intercept.MyMethodInterceptor;
import com.example.basejava.proxy.service.Hello;
import com.example.basejava.proxy.service.impl.HelloImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 14:59
 * @description:
 */
public class CGlibTest {

    public static void main(String[] args) {
        //通过 CGlib 动态获取代理对象
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloImpl.class);
        enhancer.setCallback(new MyMethodInterceptor());
        Hello helloProxy = (Hello) enhancer.create();
        helloProxy.sayHello();
        helloProxy.sayJava();
    }
}

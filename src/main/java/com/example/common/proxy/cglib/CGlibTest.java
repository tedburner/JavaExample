package com.example.common.proxy.cglib;

import com.example.common.proxy.cglib.intercept.MyMethodInterceptor;
import com.example.common.proxy.service.Hello;
import com.example.common.proxy.service.impl.HelloImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 14:59
 * @description: CGlib 动态代理测试类
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

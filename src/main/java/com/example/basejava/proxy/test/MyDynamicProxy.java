package com.example.basejava.proxy.test;

import com.example.basejava.proxy.service.Hello;
import com.example.basejava.proxy.service.impl.HelloImpl;
import com.example.basejava.proxy.test.invoke.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 13:47
 * @description:
 */
public class MyDynamicProxy {

    public static void main(String[] args) {

        HelloImpl hello = new HelloImpl();
        MyInvocationHandler handler = new MyInvocationHandler(hello);
        //构造代码实例 Proxy.newProxyInstance(类加载器, 需要实现的接口数组,InvocationHandler接口)
        Hello proxyHello = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),
                HelloImpl.class.getInterfaces(),
                handler);
        //调用代理
        proxyHello.sayHello();
        proxyHello.sayJava();
    }
}

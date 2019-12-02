package com.example.common.proxy.staticproxy;

/**
 * @author: Lucifer
 * @date: 2018-12-14 10:03
 * @description: 静态代理客户端
 */
public class StaticProxyClient {

    public static void main(String[] args) {
        HelloService helloService = new HelloServiceImpl();
        HelloServiceProxy proxy = new HelloServiceProxy(helloService);
        proxy.sayHello("Jack");
        proxy.hi("toady is sun");
    }
}

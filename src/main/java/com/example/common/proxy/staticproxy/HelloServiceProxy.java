package com.example.common.proxy.staticproxy;

/**
 * @author: Lucifer
 * @date: 2018-12-14 10:00
 * @description: 静态代理
 */
public class HelloServiceProxy implements HelloService {

    private HelloService helloService;

    public HelloServiceProxy(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("预处理....");
        String result = helloService.sayHello(name);
        System.out.println(result);
        System.out.println("后处理....");
        return result;
    }

    @Override
    public String hi(String msg) {
        System.out.println("预处理...");
        String result = helloService.hi(msg);
        System.out.println(result);
        System.out.println("后处理...");
        return result;
    }
}

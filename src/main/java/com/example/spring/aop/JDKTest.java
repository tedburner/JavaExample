package com.example.spring.aop;

import com.example.spring.aop.jdkproxy.MyInvocationHandler;
import com.example.spring.aop.service.Speakable;
import com.example.spring.aop.service.impl.PersonImpl;

import java.lang.reflect.Proxy;

/**
 * @author lingjun.jlj
 * @data 2018/5/10
 * @Description:
 */
public class JDKTest {

    public static void main(String[] args) {

        Speakable speakable = new PersonImpl();
        MyInvocationHandler handler = new MyInvocationHandler(speakable);
        // Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例
        Speakable aServiceProxy = (Speakable) Proxy.newProxyInstance(speakable
                .getClass().getClassLoader(), speakable.getClass()
                .getInterfaces(), handler);
        // 由动态生成的代理对象来aServiceProxy 代理执行程序，其中aServiceProxy 符合Service接口
        aServiceProxy.sayHi();
        System.out.println();
        aServiceProxy.sayBye();
    }
}

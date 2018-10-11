package com.example.basejava.proxy.cglib.intercept;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 15:00
 * @description:
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行GCLIB动态代理");
        return methodProxy.invokeSuper(o, objects);
    }

}

package com.example.common.proxy.cglib.intercept;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 15:00
 * @description: CGlib 动态代理
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("执行CGLIB动态代理");
        return proxy.invokeSuper(o, objects);
    }

}

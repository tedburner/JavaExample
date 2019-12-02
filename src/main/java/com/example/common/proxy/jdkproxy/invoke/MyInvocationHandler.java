package com.example.common.proxy.jdkproxy.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 13:49
 * @description:
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * @param proxy  动态代理类的引用，通常情况下不需要它
     * @param method 方法对象的引用，代表被动态代理类调用的方法
     * @param args   args对象数组，代表被调用方法的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("正在执行" + method.getName() + "方法");
        Object result = method.invoke(target, args);
        return result;
    }
}

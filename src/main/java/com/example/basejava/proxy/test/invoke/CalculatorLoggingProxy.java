package com.example.basejava.proxy.test.invoke;

import com.example.basejava.proxy.service.CalculatorService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 14:25
 * @description:
 */
public class CalculatorLoggingProxy {

    private CalculatorService target;

    public CalculatorLoggingProxy(CalculatorService calculatorService) {
        this.target = calculatorService;
    }

    public CalculatorService getProxy() {
        CalculatorService proxy = null;

        //
        ClassLoader loader = target.getClass().getClassLoader();

        Class[] interfaces = new Class[]{CalculatorService.class};

        InvocationHandler handle = new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args)
                    throws Throwable {
                System.out.println("正在执行" + method.getName() + "方法,参数为" + args[0] + "," + args[1]);
                return method.invoke(target, args);
            }
        };

        proxy = (CalculatorService) Proxy.newProxyInstance(loader, interfaces, handle);
        return proxy;
    }
}

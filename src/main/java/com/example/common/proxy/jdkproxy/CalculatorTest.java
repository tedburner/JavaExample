package com.example.common.proxy.jdkproxy;

import com.example.common.proxy.jdkproxy.invoke.CalculatorInvocationHandler;
import com.example.common.proxy.service.CalculatorService;
import com.example.common.proxy.service.impl.CalculatorServiceImpl;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 14:33
 * @description:
 */
public class CalculatorTest {

    public static void main(String[] args) {
        CalculatorService target = new CalculatorServiceImpl();

        CalculatorService proxy = new CalculatorInvocationHandler(target).getProxy();

        System.out.println(proxy.add("1", "2"));

        System.out.println(proxy.div("8", "2"));

    }
}

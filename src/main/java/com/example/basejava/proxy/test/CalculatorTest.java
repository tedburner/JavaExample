package com.example.basejava.proxy.test;

import com.example.basejava.proxy.service.CalculatorService;
import com.example.basejava.proxy.service.impl.CalculatorServiceImpl;
import com.example.basejava.proxy.test.invoke.CalculatorLoggingProxy;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/11 14:33
 * @description:
 */
public class CalculatorTest {

    public static void main(String[] args) {
        CalculatorService target = new CalculatorServiceImpl();

        CalculatorService proxy = new CalculatorLoggingProxy(target).getProxy();

        System.out.println(proxy.add("1", "2"));

        System.out.println(proxy.div("8", "2"));

    }
}

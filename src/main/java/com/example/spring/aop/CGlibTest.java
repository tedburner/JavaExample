package com.example.spring.aop;

import com.example.spring.aop.cglib.CGLibProxy;
import com.example.spring.aop.service.impl.PersonSpring;

/**
 * @author lingjun.jlj
 * @data 2018/5/10
 * @Description:
 */
public class CGlibTest {

    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        // base为生成的增强过的目标类
        PersonSpring base = PersonProxyFactory.getInstance(proxy);
        base.sayBye();
    }
}

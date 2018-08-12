package com.example.spring.aop;

import org.springframework.cglib.proxy.Enhancer;
import com.example.spring.aop.cglib.CGLibProxy;
import com.example.spring.aop.service.impl.PersonSpring;

/**
 * @author lingjun.jlj
 * @data 2018/5/9
 * @Description:
 */
public class PersonProxyFactory {
    /**
     * 获得增强之后的目标类，即添加了切入逻辑advice之后的目标类
     *
     * @param proxy
     * @return
     */
    public static PersonSpring getInstance(CGLibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonSpring.class);
        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        // 此刻，base不是单纯的目标类，而是增强过的目标类
        PersonSpring base = (PersonSpring) enhancer.create();
        return base;
    }
}

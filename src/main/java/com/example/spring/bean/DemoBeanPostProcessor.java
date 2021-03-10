package com.example.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/22 09:13
 * @description: 前置后置处理器demo
 */
public class DemoBeanPostProcessor implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Called postProcessBeforeInitialization() for : " + beanName + " and bean value is : " + bean);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Called postProcessAfterInitialization() for : " + beanName + " and bean value is : " + bean);
        return bean;
    }
}

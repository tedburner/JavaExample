package com.example.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/4 22:33
 * @description:
 */
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {
        //创建BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类AnnotationApplicationContextAsIoCContainerDemo作为配置类
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查找

    }
}

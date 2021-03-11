package com.example.spring.ioc.dependency;

import com.example.spring.ioc.annotation.Super;
import com.example.spring.ioc.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/17 20:29
 * @description: 依赖查找事例
 * 1、通过名称的方式查找
 * 2、通过类型的方式查找
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        //配置 XML 配置文件
        // 启动spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:META-INF/dependency-lookup-context.xml");
        lookupInRealTime(beanFactory);
        lookupInLazyTime(beanFactory);
        lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
        lookupByAnnotation(beanFactory);
    }

    /**
     * 通过注解查找对象
     *
     * @param beanFactory
     */
    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找标注 @Super 所有的 User 集合对象：" + userMap);
        }
    }

    /**
     * 通过类型查找集合对象
     *
     * @param beanFactory
     */
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> userMap = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到所有的 User 集合对象：" + userMap);
        }
    }

    /**
     * 通过类型查找
     *
     * @param beanFactory
     */
    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("按照类型查找" + user);
    }

    /**
     * 实时查找
     *
     * @param beanFactory
     */
    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }

    /**
     * 延迟查找
     *
     * @param beanFactory
     */
    private static void lookupInLazyTime(BeanFactory beanFactory) {
        ObjectFactory objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = (User) objectFactory.getObject();
        System.out.println("延迟查找" + user);
    }
}

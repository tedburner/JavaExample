package com.example.DesignPatterns.Singleton;

/**
 * @author lingjun.jlj
 * @data 2018/5/18
 * @Description: 使用静态内部类这种巧妙的方式来实现单例模式(推荐使用)
 * 当任何一个线程第一次调用getInstance()时，都会使SingletonHolder被加载和被初始化，此时静态初始化器将执行Singleton的初始化操作。(被调用时才进行初始化！)
 * 初始化静态数据时，Java提供了的线程安全性保证。(所以不需要任何的同步)
 */
public class SingletonTest {

    private SingletonTest() {
    }

    // 使用内部类的方式来实现懒加载
    private static class LazyHolder {
        // 创建单例对象
        private static final SingletonTest INSTANCE = new SingletonTest();
    }


    // 获取对象
    public static final SingletonTest getInstance() {
        return LazyHolder.INSTANCE;
    }
}

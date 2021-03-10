package com.example.common.concurrent.thread;

/**
 * @author: lingjun.jlj
 * @date: 2020/6/7 23:46
 * @description: 线程上下文类加载器
 */
public class MainThreadClassLoaderDemo {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}

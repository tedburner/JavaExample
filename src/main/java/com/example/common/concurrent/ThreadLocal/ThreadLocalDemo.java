package com.example.common.concurrent.ThreadLocal;


/**
 * @author: lingjun.jlj
 * @date: 2019-02-26 18:16
 * @description:
 */
public class ThreadLocalDemo {

    public ThreadLocal<String> threadLocal = new ThreadLocal<>();


    public static void main(String[] args) {
        final ThreadLocalDemo threadLocalDemo = new ThreadLocalDemo();
        threadLocalDemo.threadLocal.set("主线程，你好");
//        System.out.println(threadLocalDemo.getThreadLocal());
        System.gc();
        System.out.println(threadLocalDemo.threadLocal.get());

        new Thread(() -> {
            threadLocalDemo.threadLocal.set("第一线程开启");
            System.gc();
            System.out.println(threadLocalDemo.threadLocal.get());
        }).start();
//        System.out.println(threadLocalDemo.getThreadLocal());

//        new Thread(() -> {
//            threadLocalDemo.threadLocal.set("第二线程开启");
//            System.gc();
//            System.out.println(threadLocalDemo.threadLocal.get());
//        }).start();
//        System.out.println(threadLocalDemo.getThreadLocal());
    }
}

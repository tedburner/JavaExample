package com.example.common.concurrent.ThreadLocal;

/**
 * @author: lingjun.jlj
 * @date: 2020/7/27 12:41
 * @description: 多线程访问ThreadLocal的值
 */
public class InheritableThreadLocalDemo {

    final static ThreadLocal threadLocal = new InheritableThreadLocal();
    final static ThreadLocal<String> tl = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("张三");
        tl.set("ThreadLocal");
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("Parent ThreadLocal value is " + tl.get());
                System.out.println("Parent ThreadLocal value is " + threadLocal.get());
            }
        };
        thread.start();
    }
}

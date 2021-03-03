package com.example.common.concurrent.ThreadLocal;

/**
 * @author: lingjun.jlj
 * @date: 2020/7/27 12:41
 * @description: InheritableThreadLocal 在父子线程间传递变量值
 */
public class InheritableThreadLocalDemo {

    final static ThreadLocal<String> tl = new ThreadLocal<>();
    final static ThreadLocal<String> itl = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        tl.set("ThreadLocal");
        itl.set("张三");


        new Thread(() -> {
            System.out.println("Parent ThreadLocal value is " + tl.get());
            System.out.println("Parent ThreadLocal value is " + itl.get());
        }).start();
    }
}

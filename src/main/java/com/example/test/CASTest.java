package com.example.test;


import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lingjun.jlj
 * @date: 2018/8/7 21:39
 * @description: CAS的思想很简单：三个参数，一个当前内存值V、旧的预期值A、即将更新的值B， * 当且仅当预期值A和内存值V相同时，将内存值修改为B并返回true，否则什么都不做，并返回false。
 * * 代码如下：
 * * public boolean compareAndSwapInt(int b) {
 * *     if (a == 1) {
 * *         a = b;
 * *         return true;
 * *     }
 * *     return false;
 * * }
 */
public class CASTest {

    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        final CASTest counter = new CASTest();
        List<Thread> threads = new ArrayList<>(600);
        Long start = System.currentTimeMillis();
        for (int j = 0; j < 100; j++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        counter.count();
                        counter.safeCount();
                    }
                }
            });
            threads.add(thread);
        }
        for (Thread t : threads) {
            t.start();
        }
        //等待所有线程执行完
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(counter.i);
        System.out.println(counter.atomicInteger);
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 使用CAS实现线程安全计数器
     */
    private void safeCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            Boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    /**
     * 非线程安全计数器
     */
    private void count() {
        i++;
    }
}

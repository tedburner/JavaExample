package com.example.basejava.basics.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/30 11:24
 * @description:
 */
public class ReentrantLockTest {

    /**
     * true表示公平锁
     */
    private ReentrantLock lock = new ReentrantLock(false);

    public void testFail() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " 获得了锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        ReentrantLockTest test = new ReentrantLockTest();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            test.testFail();
        };
        Thread[] threads = new Thread[50];
        for (int i = 0; i < 50; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
        System.out.println("程序耗时：" + (System.currentTimeMillis() - start));
    }
}

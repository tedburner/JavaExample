package com.example.common.concurrent.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/30 11:24
 * @description: 可重入锁
 */
public class ReentrantLockTest {

    /**
     * true表示公平锁
     */
    private ReentrantLock lock = new ReentrantLock(false);

    public void testFail() {
        String name = Thread.currentThread().getName();
        try {
            System.out.println(name + "尝试获取锁");
            lock.lock();
            System.out.println(name + " 获得了锁");
        } finally {
            lock.unlock();
            System.out.println(name + "释放了锁");
        }
    }

    public static void main(String[] args) throws InterruptedException {
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


        Thread.sleep(15000);
    }
}

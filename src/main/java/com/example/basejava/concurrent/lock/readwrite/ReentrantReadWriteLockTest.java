package com.example.basejava.concurrent.lock.readwrite;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: lingjun.jlj
 * @date: 2018/8/7 17:01
 * @description: 读写锁测试类
 */
public class ReentrantReadWriteLockTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        //启动20个读操作
        for (int i = 1; i <= 20; i++) {
            new Thread(new ReadTask(countDownLatch, lock)).start();
        }

        //启动20个写操作
        for (int i = 1; i <= 20; i++) {
            new Thread(new WriteTask(countDownLatch, lock)).start();
        }

        countDownLatch.countDown();

        Thread.sleep(15000);
    }
}

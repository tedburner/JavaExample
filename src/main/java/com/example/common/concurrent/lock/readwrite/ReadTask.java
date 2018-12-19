package com.example.common.concurrent.lock.readwrite;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:19
 * @description:
 */
public class ReadTask implements Runnable {

    private CountDownLatch countDownLatch;
    private ReentrantReadWriteLock lock;

    public ReadTask(CountDownLatch countDownLatch, ReentrantReadWriteLock lock) {
        this.countDownLatch = countDownLatch;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取当前线程名
        String name = Thread.currentThread().getName();

        System.out.println(name + "尝试请求read锁.....");
        ReadLock readLock = lock.readLock();
        readLock.lock();

        System.out.println(name + "已经拿到read锁，开始处理业务....");

        //模拟处理业务
        try {
            Thread.sleep(new Random().nextInt(500));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(name + "释放read锁......");
        readLock.unlock();
    }
}

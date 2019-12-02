package com.example.common.concurrent.lock.spin;

import java.util.concurrent.CountDownLatch;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 11:16
 * @description: 自旋锁测试类
 */
public class SpinLockTest implements Runnable {

    private SpinLock spinLock;

    private CountDownLatch countDownLatch;

    public SpinLockTest(SpinLock spinLock, CountDownLatch countDownLatch) {
        this.spinLock = spinLock;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //尝试获取锁
        spinLock.lock();

        String threadName = Thread.currentThread().getName();

        System.out.println(threadName + "已经获取锁");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //释放锁
        System.out.println(threadName + "处理完毕，并释放锁");
        spinLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLock spinLock = new SpinLock();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        SpinLockTest task = new SpinLockTest(spinLock, countDownLatch);

        for (int i = 1; i <= 10; i++) {
            new Thread(task).start();
        }

        Thread.sleep(15000);
    }
}

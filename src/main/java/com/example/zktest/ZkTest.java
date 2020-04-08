package com.example.zktest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/8 10:09
 * @description:
 */
public class ZkTest implements Runnable {

    //库存量
    static int inventory = 1;
    private static final int num = 10;
    private static CountDownLatch countDownLatch = new CountDownLatch(num);
    Lock lock = new ReentrantLock();
    private static final ZkDistributedLock zkLock = new ZkDistributedLock("ZkLock");

    @Override
    public void run() {
        try {
            if (zkLock.tryLock()) {
                //等待所以线程就绪，去执行后续扣除库存操作
                countDownLatch.await();
                if (inventory > 0) {
                    Thread.sleep(5);
                    inventory--;
                }

                System.out.println(inventory);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            zkLock.unlock();
        }
    }


    public static void main(String[] args) {
        for (int i = 1; i <= num; i++) {
            new Thread(new ZkTest()).start();
            countDownLatch.countDown();
        }
    }
}

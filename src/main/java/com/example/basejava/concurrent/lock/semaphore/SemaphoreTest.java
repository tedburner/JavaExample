package com.example.basejava.concurrent.lock.semaphore;

import java.util.concurrent.CountDownLatch;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 11:12
 * @description: 信号量锁
 */
public class SemaphoreTest implements Runnable {

    private ResourceManage resourceManage;
    private int userId;
    private CountDownLatch countDownLatch;

    public SemaphoreTest(ResourceManage resourceManage, int userId, CountDownLatch countDownLatch) {
        this.resourceManage = resourceManage;
        this.userId = userId;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("userId:" + userId + "准备使用资源...\n");
        resourceManage.useResource(userId);
        System.out.print("userId:" + userId + "使用资源完毕...\n");
    }

    public static void main(String[] args) throws InterruptedException {
        ResourceManage resourceManage = new ResourceManage();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i <= 30; i++) {
            new Thread(new SemaphoreTest(resourceManage, i, countDownLatch)).start();
        }
        countDownLatch.countDown();

        Thread.sleep(15000);

    }
}

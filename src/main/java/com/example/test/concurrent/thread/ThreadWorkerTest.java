package com.example.test.concurrent.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lingjun.jlj
 * @date: 2019/12/3 21:37
 * @description:
 */
public class ThreadWorkerTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch l1 = new CountDownLatch(2);
        for (int i = 0; i < 2; i++) {
            System.out.println("L1");
            //执行L1阶段任务
            executor.execute(() -> {
                //L2阶段的闭锁
                CountDownLatch l2 = new CountDownLatch(2);
                //执行L2阶段子任务
                for (int j = 0; j < 2; j++) {
                    executor.execute(() -> {
                        System.out.println("L2");
                        l2.countDown();
                    });
                }
                //等待L2阶段任务执行完
                try {
                    l2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                l1.countDown();
            });
        }
        l1.await();
        System.out.println("end");

    }
}

package com.example.common.concurrent.pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: Arthas
 * @date: 2019-01-09 10:55
 * @description:
 */
public class MockServiceExample {

    //使用场景：在主线程中开启多个任务，并且主线程需要等待其他子任务全部执行完毕之后才能汇总结果继续执行
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.prestartAllCoreThreads(); //预先将核心线程都启动起来

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long cost = System.currentTimeMillis() - s1;

        System.out.println("cost:" + cost);
        threadPoolExecutor.shutdownNow();
    }
}

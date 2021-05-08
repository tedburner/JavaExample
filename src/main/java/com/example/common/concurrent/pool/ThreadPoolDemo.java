package com.example.common.concurrent.pool;

import com.example.utils.DateFormatUtils;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/13 14:29
 * @description: 模拟测试非核心线程数，在过期时间后，是否会被销毁。
 * 测试：
 * 线程池: core = 2, maxPoolSize = 3, keepAliveTime = 30s，QueueSize = 2
 * <p>
 * 过程：
 * 1.先提交5个任务，模拟工作线程最大线程池
 * 2.休眠10s，观察线程池状态
 * 3.每个3s向线程池丢入一个任务，观察线程池状态。
 * <p>
 * 理想状态：按照理论，在执行5个任务后，线程池的工作线程已经扩展到最大线程数了。然后休眠10s后，每隔3s执行一个任务，原则上，
 * 这时候，应该是核心线程数在执行新来的任务，然后非核心线程数空闲。所以，理论上，非核心线程，在空闲30s后，会被释放掉，然后线程池中的线程数
 * 就剩核心线程数， poolSize = 2。
 * <p>
 * 实际：在运行时间超过 keepAliveTime 后，非核心线程池并未释放掉线程，线程数 poolSize = 3。
 * <p>
 * 原因：虽然线程池中的线程都是空闲的，但是当任务来的时候，并不是随机调用线程的，而是轮询。对于线程池中的线程，并没有标记那些线程是核心或者非核心这样的概念。
 * 线程池中的线程，是在 AbstractQueuedSynchronizer#ConditionObject中。每个Condition对象都包含一个队列，该队列是Condition对象实现等待/通知功能的关键。
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor executorService = new ThreadPoolExecutor(2, 3, 30, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(2), new DefaultThreadFactory("test"),
                new ThreadPoolExecutor.DiscardPolicy());

        //每隔两秒打印线程池的信息
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("=====================================thread-pool-info: " + DateFormatUtils.getCurrentTime() + " =====================================");
            System.out.println("CorePoolSize:" + executorService.getCorePoolSize());
            System.out.println("MaxPoolSize: " + executorService.getMaximumPoolSize());
            System.out.println("PoolSize:" + executorService.getPoolSize());
            System.out.println("ActiveCount:" + executorService.getActiveCount());
            System.out.println("KeepAliveTime:" + executorService.getKeepAliveTime(TimeUnit.SECONDS));
            System.out.println("QueueSize:" + executorService.getQueue().size());
        }, 0, 2, TimeUnit.SECONDS);

        try {
            //同时提交5个任务,模拟达到最大线程数
            for (int i = 0; i < 10; i++) {
                executorService.execute(new Task());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //休眠10秒，打印日志，观察线程池状态
        Thread.sleep(10000);

        //每隔3秒提交一个任务
        while (true) {
            Thread.sleep(3000);
            executorService.submit(new Task());
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "-执行任务");
        }
    }
}

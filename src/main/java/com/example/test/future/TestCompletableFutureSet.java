package com.example.test.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/31 23:06
 * @description:
 */
public class TestCompletableFutureSet {

    //创建线程池
    private final static int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final static ThreadPoolExecutor POOL_EXECUTOR = new ThreadPoolExecutor(AVAILABLE_PROCESSORS,
            AVAILABLE_PROCESSORS * 2, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>(5),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建一个 CompletableFuture 对象
        CompletableFuture<String> future = new CompletableFuture<>();

        //开启线程计算结果，并设置
        POOL_EXECUTOR.execute(() -> {
            // 线程睡眠3s，模拟任务计算
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //这只计算结果到future中
            System.out.println("--- " + Thread.currentThread().getName() + " set future result ----");
            future.complete("Hello World!");
        });
        //等待计算结果
        System.out.println("--- main thread wait future result ---");
        System.out.println(future.get());
        System.out.println("--- main thread wait future ---");
    }
}

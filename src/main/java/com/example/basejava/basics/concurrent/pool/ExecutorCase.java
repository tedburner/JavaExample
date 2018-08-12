package com.example.basejava.basics.concurrent.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lingjun.jlj
 * @data 2018/5/9
 * @Description: Future和Callable基本是成对出现的，Callable负责产生结果
 * 通过Future和Callable来获取线程池中任务的返回结果
 */
public class ExecutorCase {

    private static ExecutorService threadPools = Executors.newFixedThreadPool(10);

    static class Task implements Callable<String> {

        @Override
        public String call() {
            try {
                TimeUnit.SECONDS.sleep(2);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "This is future case";
        }
    }

    public static void main(String[] args) {
        Future<String> future = threadPools.submit(new Task());
        System.out.println("do Something!");
        try {
            String result = future.get();
            System.out.println(result);

        } catch (Exception e) {

        }

    }


}

package com.example.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2018-12-05 11:05
 * @description:
 */
public class Counter {

    private static int count = 0;

    public static synchronized int getCount() {
        return count;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }


    public static void main(String[] args) throws InterruptedException {


        ExecutorService threadPool = Executors.newCachedThreadPool();


        for (int i = 0; i < 10; i++) {


            threadPool.submit(() -> {
                Counter counter = new Counter();

                counter.setCount(Counter.getCount() + 1);
            });
        }

        threadPool.shutdown();

        threadPool.awaitTermination(1, TimeUnit.SECONDS);


        System.out.println(Counter.getCount());

    }

}

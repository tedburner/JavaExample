package com.example.algorithm.mianshi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/23 09:58
 * @description:
 */
public class ThreadNumberPrint implements Runnable {

    private static final AtomicInteger value = new AtomicInteger(0);
    private static final int n = 100;
    private static final CountDownLatch latch = new CountDownLatch(n);

    @Override
    public void run() {
        try {
            int totalNumber = 100;
            while (value.get() < totalNumber) {
                synchronized (value) {
                    String threadName = Thread.currentThread().getName();
                    int taskThreadNum = Integer.parseInt(threadName);
                    if (value.get() == taskThreadNum || value.get() % n == taskThreadNum) {
                        System.out.println("Thread" + threadName + " value is " + value);
                        value.getAndIncrement();
                        value.notifyAll();
                    } else {
                        value.wait();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            new Thread(new ThreadNumberPrint(), "" + i).start();
        }
    }
}

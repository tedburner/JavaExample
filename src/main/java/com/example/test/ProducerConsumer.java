package com.example.test;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/4 15:46
 * @description: 生成消费
 */
public class ProducerConsumer {
    private static final int Q_SIZE = 10;
    private LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(Q_SIZE);
    private volatile boolean stop = false;

    Runnable producer = () -> {
        while (!stop) {
            try {
                queue.offer(UUID.randomUUID().toString(), 1, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    Runnable consumer = () -> {
        while (!stop) {
            try {
                String value = queue.take();
                System.out.println(Thread.currentThread().getName() + " | " + value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    void start(){
        new Thread(producer, "Thread 1").start();
        new Thread(producer, "Thread 2").start();
        new Thread(consumer, "Thread 3").start();
        new Thread(consumer, "Thread 4").start();
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();
        pc.start();
    }
}

package com.example.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/13 15:17
 * @description:
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        queue.offer("Test1");
        String result = queue.poll(1, TimeUnit.SECONDS);
        System.out.println(result);
    }
}

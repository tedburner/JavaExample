package com.example.common.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/27 17:17
 * @description:
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) {

        ArrayBlockingQueue queue = new ArrayBlockingQueue(100);

        for (int i = 0; i < 1000; i++) {
            queue.add(i);
            queue.offer(i);
        }

        System.out.println(queue.poll());
    }
}

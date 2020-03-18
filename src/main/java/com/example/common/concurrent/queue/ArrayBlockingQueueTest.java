package com.example.common.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/27 17:17
 * @description:
 */
public class ArrayBlockingQueueTest {

    public static void main(String[] args) {
        //创建一个公平的阻塞队列
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(100, true);

        for (int i = 0; i < 1000; i++) {
            queue.add(i);
            queue.offer(i);
        }

        System.out.println(queue.poll());
    }
}

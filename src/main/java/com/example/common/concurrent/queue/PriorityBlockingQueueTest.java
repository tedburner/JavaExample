package com.example.common.concurrent.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/29 15:25
 * @description: 支持优先级排序的无界阻塞队列
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) {
        PriorityBlockingQueue queue = new PriorityBlockingQueue();
        queue.put(1);
        queue.add(2);
        queue.offer(3);
        queue.poll();
    }
}

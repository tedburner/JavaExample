package com.example.basejava.basics.concurrent.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/27 14:53
 * @description: 非阻塞算法--队列
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
        for (int i = 0; i < 100; i++) {
            queue.add(i);
            //指定元素插入到队列尾部
            queue.offer(i);
        }
        System.out.println(queue.poll());
    }
}

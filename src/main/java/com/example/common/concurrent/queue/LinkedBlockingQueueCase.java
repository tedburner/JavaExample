package com.example.common.concurrent.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: lingjun.jlj
 * @date: 2020/3/18 15:01
 * @description: 链表结构组成的有界阻塞队列
 */
public class LinkedBlockingQueueCase {

    public static void main(String[] args) {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue(10);
        for (int i = 0; i < 12; i++) {
            queue.add(i);
        }

    }
}

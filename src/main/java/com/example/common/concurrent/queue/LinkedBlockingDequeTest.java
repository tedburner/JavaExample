package com.example.common.concurrent.queue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/30 14:53
 * @description: 由链表结构组成的双向阻塞队列
 */
public class LinkedBlockingDequeTest {

    public static void main(String[] args) {
        LinkedBlockingDeque deque = new LinkedBlockingDeque(100);
        deque.add(1);
        deque.addFirst(0);
        deque.addLast(100);
        deque.offer(3);

        deque.peekFirst();
        deque.peekLast();
        deque.peek();
        deque.poll();

    }
}

package com.example.algorithm.mianshi;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/23 10:14
 * @description: 使用Queue的方法实现Stack
 */
public class MyStack {

    public Queue<Integer> queue;
    public Queue<Integer> queueB;
    public int capacity;
    public static int top = 0;

    public MyStack(int capacity) {
        this.queue = new LinkedList<>();
        this.queueB = new LinkedList<>();
        this.capacity = capacity;
    }

    public void push(int item) {
        if ((top + 1) > capacity) {
            throw new RuntimeException("堆栈容量超出");
        }
        queue.offer(item);
        while (!queueB.isEmpty()) {
            //将队列B中的元素重新放入到队列
            queue.offer(queueB.poll());
        }
        //保证队列A始终是空队列
        Queue<Integer> temp = queue;
        queue = queueB;
        queueB = temp;
        top++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("堆栈内没有数据");
        }
        return queueB.poll();
    }

    public boolean isEmpty() {
        return queueB.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack(10);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }
}

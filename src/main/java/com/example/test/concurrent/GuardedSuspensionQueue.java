package com.example.test.concurrent;

import java.util.LinkedList;

/**
 * @author: lingjun.jlj
 * @date: 2020/6/10 14:23
 * @description:
 */
public class GuardedSuspensionQueue {

    private final LinkedList<Integer> queue = new LinkedList<>();

    private final int LIMIT = 100;

    public void offer(Integer data) throws InterruptedException {
        synchronized (this){
            while (queue.size() >= LIMIT){
                //挂起当前线程，阻塞
                this.wait();
            }
            //插入元素并唤醒take线程
            queue.addLast(data);
            this.notifyAll();
        }
    }

    public Integer take() throws InterruptedException {
        synchronized (this){
            while (queue.isEmpty()){
                //当前队列为空，阻塞，挂起线程
                this.wait();
            }
            //通知offer 线程可以继续插入数据了
            this.notifyAll();
            return queue.removeFirst();
        }
    }
}

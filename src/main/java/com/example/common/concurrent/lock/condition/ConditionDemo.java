package com.example.common.concurrent.lock.condition;

import com.alibaba.fastjson.JSON;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:45
 * @description: 条件变量 Condition 锁
 */
public class ConditionDemo {

    private ReentrantLock lock = new ReentrantLock();
    private Condition take = lock.newCondition();
    private Condition put = lock.newCondition();

    private BlockingQueue queue = new ArrayBlockingQueue(100);
    //队列最大容量
    private int capacity = 5;
    //初始值
    private int i = 1;

    /**
     * 向队列塞入数据
     */
    public void put() {
        lock.lock();
        System.out.println(String.format("【put】 i = %d 获取锁！！！！", i));
        try {
            while (Objects.equals(capacity, queue.size())) {
                System.out.printf("【put】插入 %d 时队列满，执行put.await！队列值：【%s】%n", i,
                        JSON.toJSONString(queue.toArray()));

                put.await();
            }

            queue.put(i);
            System.out.printf("【put】插入 %d 到队列%n", i);
            i++;

            // 读操作唤醒
            take.signal();

        } catch (Exception e) {

        } finally {
            System.out.printf("【put】i=%d 释放锁!!!%n", i - 1);
            lock.unlock();
        }
    }

    /**
     * 从队列读数据
     */
    public void take() {
        lock.lock();
        System.out.println("【take】获取锁！");

        int data = 0;
        try {
            while (queue.size() == 0) {
                System.out.println("【take】执行take.await！");
                take.await();
            }
            data = (int) queue.take();
            System.out.printf("【take】从队列读取值 %d ,队列值：【%s】%n", data, JSON.toJSONString(queue.toArray()));

            // 写操作唤醒
            put.signal();
        } catch (Exception e) {
        } finally {
            System.out.printf("【take】i=%d 释放锁!!!%n", data);
            lock.unlock();
        }
    }

}

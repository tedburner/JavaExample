package com.example.common.concurrent.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/15 16:08
 * @description:
 */
public class ConTest {

    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConTest con = new ConTest();
        Producer producer = con.new Producer();
        Consumer consumer = con.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("线程" + Thread.currentThread().getName() + "在等待信号");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("线程" + Thread.currentThread().getName() + "拿到一个信号");
                lock.unlock();
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("线程" + Thread.currentThread().getName() + "拿到锁");
                condition.signalAll();
                System.out.println("线程" + Thread.currentThread().getName() + "发出一个信号");
            } finally {
                lock.unlock();
            }
        }
    }
}

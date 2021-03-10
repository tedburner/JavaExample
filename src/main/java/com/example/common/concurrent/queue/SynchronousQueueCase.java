package com.example.common.concurrent.queue;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2020/3/18 15:09
 * @description: 是一个不存储元素的阻塞队列，每一个put操作必须等待一个take操作，否则不能继续添加元素
 */
public class SynchronousQueueCase {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue(true);

        new Product(queue).start();
        new Customer(queue).start();
    }

    static class Product extends Thread {
        SynchronousQueue<Integer> queue;

        public Product(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int rand = new Random().nextInt(1000);
                System.out.println("生产了一个产品：" + rand);
                System.out.println("等待三秒后运送出去...");
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    queue.put(rand);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(queue.isEmpty());
            }
        }
    }

    static class Customer extends Thread {
        SynchronousQueue<Integer> queue;

        public Customer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("消费了一个产品:" + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("------------------------------------------");
            }
        }
    }
}

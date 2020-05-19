package com.example.common.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2018/8/17 19:43
 * @description: thread.join的含义是当前线程需要等待 previous 线程终止之后才从thread.join返回。
 * 简单来说，就是线程没有执行完之前，会一直阻塞在join方法处。
 */
public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread previous = Thread.currentThread();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new domino(previous), String.valueOf(i));
            thread.start();
            previous = thread;
        }
        TimeUnit.SECONDS.sleep(5);
        System.out.println(Thread.currentThread().getName() + " terminate.");
    }

    static class domino implements Runnable {
        private Thread thread;

        public domino(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " terminate.");
        }
    }
}

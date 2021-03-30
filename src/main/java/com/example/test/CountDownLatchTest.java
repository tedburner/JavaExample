package com.example.test;

import java.util.concurrent.CountDownLatch;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/9 17:47
 * @description:
 */
public class CountDownLatchTest {


    static class printSomething implements Runnable {
        private CountDownLatch latch;

        public printSomething(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(100);
                System.out.println(latch.getCount());
                latch.await();
                Thread.sleep(200);
                System.out.println(latch.getCount());
                System.out.println("子线程等待CountDown执行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class printB implements Runnable {
        @Override
        public void run() {
            System.out.println("子线程等待CountDown执行结束");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Thread thread = new Thread(new printSomething(latch));
        thread.setName("CountDownLatch Thread");
        thread.start();
        Thread.sleep(2000);
        latch.countDown();
        System.out.println("主线程结束");
    }
}

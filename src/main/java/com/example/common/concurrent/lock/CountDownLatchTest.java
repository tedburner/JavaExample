package com.example.common.concurrent.lock;


import java.util.concurrent.CountDownLatch;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/24 14:01
 * @description:
 */
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(5);

    static class BossThread extends Thread {
        @Override
        public void run() {
            System.out.println("Boss在会议室等待，总共有" + countDownLatch.getCount() + "人在开会");
            try {
                //Boss等待
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("所有人都已经到齐了，开会吧....");
        }
    }

    static class EmployeeThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", 到达会议室....");
            //员工到达会议室
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) {
        new BossThread().start();
        for (int i = 0; i < countDownLatch.getCount(); i++) {
            //System.out.println(countDownLatch.getCount());
            new EmployeeThread().start();
        }
    }
}

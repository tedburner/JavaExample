package com.example.common.jvm.gc;

/**
 * @author: lingjun.jlj
 * @date: 2021/5/31 14:42
 * @description: jstat 分析死锁
 */
public class DeadLockTest {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();

    private static class Thread1 implements Runnable {

        @Override
        public void run() {
            synchronized (obj1) {
                System.out.println("Thread1 拿到了 obj1 的锁");
                try {
                    // 为了保证两个线程处于竞争状态
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("Thread1 拿到了 obj2 的锁");
                }
            }
        }
    }

    private static class Thread2 implements Runnable {

        @Override
        public void run() {
            synchronized (obj2) {
                System.out.println("Thread2 拿到了 obj2 的锁");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("Thread2 拿到了 obj1 的锁");
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Thread1()).start();
        new Thread(new Thread2()).start();
    }

}

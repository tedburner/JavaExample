package com.example.test.lock;

/**
 * @author: Lucifer
 * @date: 2018/11/18 14:39
 * @description: 死锁实例
 */
public class DeadLockDemo {

    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();

    }

    private void deadLock() {
        Thread thread1 = new Thread(() -> {
            synchronized (A) {
                System.out.println("thread1 " + A);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (B) {
                    System.out.println("获取资源" + B);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (B) {
                System.out.println("thread2 " + B);
                synchronized (A) {
                    System.out.println("获取资源" + A);
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

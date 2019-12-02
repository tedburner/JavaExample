package com.example.common.concurrent.lock.syn;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:12
 * @description: synchronized修饰静态方法
 */
public class SynchronizedStaticMethod {

    public synchronized static void m1() {
        System.out.println("m1方法获得锁");
        try {
            Thread.sleep(1200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("m1方法释放锁");
    }

    public synchronized static void m2() {
        System.out.println("m2方法获得锁");
        try {
            Thread.sleep(1200);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("m2方法释放锁");
    }

    static class Task1 implements Runnable {

        @Override
        public void run() {
            m1();
        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            m2();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Task1()).start();
        new Thread(new Task2()).start();

        Thread.sleep(15000);
    }
}

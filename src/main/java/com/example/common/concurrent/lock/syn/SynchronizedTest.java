package com.example.common.concurrent.lock.syn;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/27 10:38
 * @description:
 */
public class SynchronizedTest {

    public void m1() {
        synchronized (SynchronizedTest.class) {
            System.out.println("m1方法获取锁！");
            try {
                Thread.sleep(1200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("m1方法释放锁！");
        }
    }

    public void m2() {
        synchronized (SynchronizedTest.class) {
            System.out.println("m2方法获取锁");
            try {
                Thread.sleep(1200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("m2方法释放锁");
        }
    }

    static class Task1 implements Runnable {

        private SynchronizedTest synchronizedTest;

        public Task1(SynchronizedTest synchronizedTest) {
            this.synchronizedTest = synchronizedTest;
        }

        @Override
        public void run() {
            synchronizedTest.m1();
        }
    }

    static class Task2 implements Runnable {

        private SynchronizedTest synchronizedTest;

        public Task2(SynchronizedTest synchronizedTest) {
            this.synchronizedTest = synchronizedTest;
        }

        @Override
        public void run() {
            synchronizedTest.m2();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest syn = new SynchronizedTest();
        new Thread(new Task1(syn)).start();
        new Thread(new Task2(syn)).start();

        //主线程阻塞，防止JVM提早退出
        Thread.sleep(15000L);
    }
}

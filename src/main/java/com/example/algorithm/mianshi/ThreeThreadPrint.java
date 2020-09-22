package com.example.algorithm.mianshi;

import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/13 20:28
 * @description: 三个线程循环打印ABC
 */
public class ThreeThreadPrint {

    private static final Object monitor = new Object();
    private static volatile int flag = 1;

    static class printA implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                synchronized (monitor) {
                    while (flag != 1) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(thread.getName() + "A");
                    flag = 2;
                    monitor.notifyAll();
                }
            }
        }
    }

    static class printB implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                synchronized (monitor) {
                    while (flag != 2) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(thread.getName() + "B");
                    flag = 3;
                    monitor.notifyAll();
                }
            }
        }
    }

    static class printC implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                synchronized (monitor) {
                    while (flag != 3) {
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(thread.getName() + "C");
                    flag = 1;
                    monitor.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new printA());
        threadA.setName("线程一: ");
        threadA.start();
        Thread threadB = new Thread(new printB());
        threadB.setName("线程二: ");
        threadB.start();
        Thread threadC = new Thread(new printC());
        threadC.setName("线程三: ");
        threadC.start();
        TimeUnit.SECONDS.sleep(5);
    }
}

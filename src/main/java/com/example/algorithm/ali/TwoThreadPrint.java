package com.example.algorithm.ali;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/26 21:26
 * @description: 线程交替打印奇偶数
 */
public class TwoThreadPrint {
    private static Object monitor = new Object();
    private static volatile int i = 0;

    public static void main(String[] args) {
        //打印奇数
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    i++;
                    if (i > 50) {
                        return;
                    }
                    if (i % 2 != 0) {
                        monitor.notify();
                        System.out.println("奇数线程：" + i);
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        //打印偶数
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    i++;
                    if (i > 50) {
                        return;
                    }
                    if (i % 2 == 0) {
                        monitor.notify();
                        System.out.println("偶数线程：" + i);
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }
}

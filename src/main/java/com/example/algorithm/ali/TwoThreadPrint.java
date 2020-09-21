package com.example.algorithm.ali;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/21 21:44
 * @description:
 */
public class TwoThreadPrint {
    private static Object monitor = new Object();
    private static volatile int i = 0;

    public static void main(String[] args) {
        //线程1打印奇数
        new Thread(()->{
            while (true){
                synchronized (monitor){
                    i++;
                    if (i > 100) {
                        return;
                    }
                    if (i % 2 != 0) {
                        monitor.notify();
                        System.out.println("Thread1 -" + i);
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        //线程2打印偶数
        new Thread(()->{
            synchronized (monitor){
                i++;
                if (i > 100) {
                    return;
                }
                if (i % 2 != 0) {
                    monitor.notify();
                    System.out.println("Thread2 -" + i);
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

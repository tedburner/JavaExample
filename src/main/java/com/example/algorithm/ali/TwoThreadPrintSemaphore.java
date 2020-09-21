package com.example.algorithm.ali;

import java.util.concurrent.Semaphore;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/26 21:26
 * @description: 使用Semaphore实现线程交替打印奇偶数
 */
public class TwoThreadPrintSemaphore {

    // 奇数信号量，偶数信号量默认初始化0
    private static final Semaphore ODD_NUMBER = new Semaphore(1);
    private static final Semaphore EVEN_NUMBER = new Semaphore(0);

    private static volatile int i = 0;

    /**
     * 打印奇数
     */
    static class printOddNumber implements Runnable {
        @Override
        public void run() {
            try {
                ODD_NUMBER.acquire();
                while (true) {
                    i++;
                    if (i > 100) {
                        return;
                    }
                    if (i % 2 != 0) {
                        System.out.println("奇数线程：" + i);
                        //偶数信号量加一
                        EVEN_NUMBER.release();
                        Thread.sleep(20);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 打印偶数
     */
    static class printEvenNumber implements Runnable {
        @Override
        public void run() {
            try {
                EVEN_NUMBER.acquire();
                while (true) {
                    i++;
                    if (i > 100) {
                        return;
                    }
                    if (i % 2 == 0) {
                        System.out.println("偶数线程：" + i);
                        ODD_NUMBER.release();
                        Thread.sleep(20);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TwoThreadPrintSemaphore.printOddNumber()).start();
        new Thread(new TwoThreadPrintSemaphore.printEvenNumber()).start();
    }
}

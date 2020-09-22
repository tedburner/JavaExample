package com.example.algorithm.mianshi;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/21 17:07
 * @description: 三个线程交替打印ABC，使用信号量
 */
public class ThreeThreadPrintSemaphore {
    // 以A开始的信号量,初始信号量数量为1,B C 信号量在A完成后开始，初始数量为0
    private static final Semaphore A = new Semaphore(1);
    private static final Semaphore B = new Semaphore(0);
    private static final Semaphore C = new Semaphore(0);

    static class printA implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                try {
                    //信号量A减一
                    A.acquire();
                    System.out.println(thread.getName() + "A");
                    //信号量B加一
                    B.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class printB implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                try {
                    //信号量B减一
                    B.acquire();
                    System.out.println(thread.getName() + "B");
                    //信号量C加一
                    C.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class printC implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            for (int i = 0; i < 10; i++) {
                try {
                    //信号量B减一
                    C.acquire();
                    System.out.println(thread.getName() + "C");
                    //信号量C加一
                    A.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new ThreeThreadPrintSemaphore.printA());
        threadA.setName("线程一: ");
        threadA.start();
        Thread threadB = new Thread(new ThreeThreadPrintSemaphore.printB());
        threadB.setName("线程二: ");
        threadB.start();
        Thread threadC = new Thread(new ThreeThreadPrintSemaphore.printC());
        threadC.setName("线程三: ");
        threadC.start();
        TimeUnit.SECONDS.sleep(5);
    }
}

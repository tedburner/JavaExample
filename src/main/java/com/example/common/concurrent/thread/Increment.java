package com.example.common.concurrent.thread;

/**
 * @author lingjun.jlj
 * @data 2018/5/8
 * @Description: 原子性操作就是一个或某几个操作只能在一个线程执行完之后，
 * 另一个线程才能开始执行该操作，也就是说这些操作是不可分割的，线程不能在这些操作上交替执行
 */
public class Increment {
    private volatile int i;

    public void increase() {
        i++;
    }

    public int getI() {
        return i;
    }

    public static void test(int threadNum, int loopTimes) {
        Increment increment = new Increment();

        Thread[] threads = new Thread[threadNum];

        for (int i = 0; i < threads.length; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < loopTimes; i++) {
                        increment.increase();
                    }
                }
            });
            threads[i] = t;
            t.start();
        }

        for (Thread t : threads) {  //main线程等待其他线程都执行完成
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(threadNum + "个线程，循环" + loopTimes + "次结果：" + increment.getI());
    }

    public static void main(String[] args) {
        test(20, 1);
        test(20, 10);
        test(20, 100);
        test(20, 1000);
        test(20, 10000);
        test(20, 100000);
    }
}

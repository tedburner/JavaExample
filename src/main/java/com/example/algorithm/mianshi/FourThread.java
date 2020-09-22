package com.example.algorithm.mianshi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/11 09:42
 * @description: 给定一个数组[1, 2, 3, 4, 5, 6, 7, 8, 9...., 15]，要求遍历数组，遇到可以同时被3和5整除的数字，打印C；遇到仅能被5整除的数字，
 * 打印B；遇到仅能被3整除的数字，打印A；其他打印数字本身；
 */
public class FourThread implements Runnable {
    private static final int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static final AtomicInteger currentCount = new AtomicInteger(0);

    private int flag;
    private PrintFunction printFunction;

    public FourThread(int flag, PrintFunction printFunction) {
        this.flag = flag;
        this.printFunction = printFunction;
    }

    @FunctionalInterface
    interface PrintFunction {
        void print(int n);
    }

    private int check(int n) {
        if (n % 15 == 0) {
            return 0;
        } else if (n % 5 == 0) {
            return 1;
        } else if (n % 3 == 0) {
            return 2;
        } else {
            return 3;
        }

    }


    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                //如果不满足条件的线程，挂起
                while (currentCount.get() < array.length && check(array[currentCount.get()]) % 4 != flag) {
                    condition.await();
                }
                //对于满足条件的，进行打印，并且唤醒线程
                if (currentCount.get() < array.length) {
                    printFunction.print(array[currentCount.get()]);
                    currentCount.addAndGet(1);
                    condition.signalAll();
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new FourThread(0, (n) -> System.out.println("C"))).start();
        new Thread(new FourThread(1, (n) -> System.out.println("B"))).start();
        new Thread(new FourThread(2, (n) -> System.out.println("A"))).start();
        new Thread(new FourThread(3, System.out::println)).start();
    }
}

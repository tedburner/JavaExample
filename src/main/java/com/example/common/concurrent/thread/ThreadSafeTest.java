package com.example.common.concurrent.thread;

/**
 * @author lingjun.jlj
 * @create 2017-09-07
 **/
public class ThreadSafeTest implements Runnable {

    int num = 10;

    public static void main(String[] args) {

        ThreadSafeTest t = new ThreadSafeTest();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    @Override
    public void run() {
        while (true) {
            synchronized (ThreadSafeTest.class) {
                if (num > 0) {
                    try {
                        Thread.sleep(100);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("还有车票" + num-- + "张");
                }
            }
        }
    }
}

package com.example.test.concurrent.thread;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/10 15:36
 * @description: 创建线程判断线程是否中断，且count值小于1000，打印数字。
 */
public class StopThread implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println("count = " + count++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new StopThread());
        thread.start();
        Thread.sleep(5);
        thread.interrupt();
    }
}

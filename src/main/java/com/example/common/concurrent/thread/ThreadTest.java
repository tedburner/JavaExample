package com.example.common.concurrent.thread;

/**
 * @author lingjun.jlj
 * @date: 2018/5/8
 * @Description:
 */
public class ThreadTest extends Thread{


    @Override
    public void run() {
        System.out.println("运行一个线程");
    }

    public static void main(String[] args) {
         ThreadTest thread = new ThreadTest();
         thread.start();
         System.out.println(thread.getId());
         System.out.println("优先级："+thread.getPriority());
    }
}

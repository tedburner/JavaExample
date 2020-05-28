package com.example.common.concurrent.thread.group;

import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/26 16:35
 * @description:
 */
public class ThreadGroupEnumerateThreads {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup myGroup = new ThreadGroup("MyGroup");
        Thread thread = new Thread(()->{
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MyThread");
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        Thread[] list = new Thread[mainGroup.activeCount()];
        int recurseSize = mainGroup.enumerate(list);
        System.out.println(recurseSize);

        recurseSize = mainGroup.enumerate(list, false);
        System.out.println(recurseSize);
    }
}

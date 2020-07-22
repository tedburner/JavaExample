package com.example.common.concurrent.lock.syn;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:12
 * @description: synchronized修饰静态方法
 */
public class SynchronizedStaticMethod {

    public synchronized static void method(String arg) {
        System.out.println(arg + "获得锁");
        try {
            Thread.sleep(1200);
            System.out.println(arg + "正在处理事情");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(arg + "释放锁");
    }


    static class Task implements Runnable {

        private String arg;

        public Task(String arg) {
            this.arg = arg;
        }

        @Override
        public void run() {
            method(arg);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SynchronizedStaticMethod syn = new SynchronizedStaticMethod();
        new Thread(new Task("A")).start();
        new Thread(new Task("B")).start();

        // 主线程阻塞，防止jvm提早退出
        Thread.sleep(150000);
    }
}

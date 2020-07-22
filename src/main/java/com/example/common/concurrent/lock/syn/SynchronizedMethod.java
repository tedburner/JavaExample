package com.example.common.concurrent.lock.syn;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:14
 * @description: synchronized修饰非静态方法
 */
public class SynchronizedMethod {


    public synchronized void method(String arg) {
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

        private SynchronizedMethod synchronizedMethod;
        private String arg;

        public Task(SynchronizedMethod synchronizedMethod, String arg) {
            this.synchronizedMethod = synchronizedMethod;
            this.arg = arg;
        }

        @Override
        public void run() {
            synchronizedMethod.method(arg);
        }
    }


    public static void main(String[] args) throws InterruptedException {
        SynchronizedMethod syn = new SynchronizedMethod();
        new Thread(new Task(syn, "A")).start();
        new Thread(new Task(syn, "B")).start();

        // 主线程阻塞，防止jvm提早退出
        Thread.sleep(150000);
    }

}

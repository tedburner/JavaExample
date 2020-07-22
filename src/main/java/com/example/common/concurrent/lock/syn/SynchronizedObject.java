package com.example.common.concurrent.lock.syn;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:15
 * @description:
 */
public class SynchronizedObject {

    private Object lock = new Object();

    public void method(String arg) {
        synchronized (lock) {
            System.out.println(arg + "获得锁");
            try {
                Thread.sleep(1200);
                System.out.println(arg + "正在处理事情");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(arg + "释放锁");
        }
    }

    static class Task implements Runnable {

        private SynchronizedObject synchronizedObject;
        private String arg;

        public Task(SynchronizedObject synchronizedObject, String arg) {
            this.synchronizedObject = synchronizedObject;
            this.arg = arg;
        }

        @Override
        public void run() {
            synchronizedObject.method(arg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject syn = new SynchronizedObject();
        new Thread(new Task(syn, "A")).start();
        new Thread(new Task(syn, "B")).start();

        // 主线程阻塞，防止jvm提早退出
        Thread.sleep(15000);
    }
}

package com.example.common.concurrent.lock.syn;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:17
 * @description: 同步代码块的synchronized (this)
 */
public class SynchronizedThis {

    public void method(String arg) {
        synchronized (this) {
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

        private SynchronizedThis synchronizedThis;
        private String arg;

        public Task(SynchronizedThis synchronizedThis, String arg) {
            this.synchronizedThis = synchronizedThis;
            this.arg = arg;
        }

        @Override
        public void run() {
            synchronizedThis.method(arg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedThis syn = new SynchronizedThis();
        new Thread(new Task(syn, "A")).start();
        new Thread(new Task(syn, "B")).start();

        // 主线程阻塞，防止jvm提早退出
        Thread.sleep(15000);
    }
}

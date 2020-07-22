package com.example.common.concurrent.lock.syn;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/27 10:38
 * @description:
 */
public class SynchronizedTest {


    public void method(String arg) {
        synchronized (SynchronizedTest.class) {
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

        private SynchronizedTest synchronizedTest;
        private String arg;

        public Task(SynchronizedTest synchronizedTest, String arg) {
            this.synchronizedTest = synchronizedTest;
            this.arg = arg;
        }

        @Override
        public void run() {
            synchronizedTest.method(arg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedTest syn = new SynchronizedTest();
        new Thread(new Task(syn, "A")).start();
        new Thread(new Task(syn, "B")).start();

        // 主线程阻塞，防止jvm提早退出
        Thread.sleep(15000);
    }
}

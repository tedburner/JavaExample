package com.example.common.concurrent.lock.syn;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:15
 * @description: 通过传入参数进行锁定
 */
public class SynchronizedParam {


    public void method(String arg) {
        synchronized (arg) {
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

        private SynchronizedParam synchronizedParam;
        private String param;

        public Task(SynchronizedParam synchronizedParam, String param) {
            this.synchronizedParam = synchronizedParam;
            this.param = param;
        }

        @Override
        public void run() {
            synchronizedParam.method(param);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //
        String A = "A";
        String B = "A";
        SynchronizedParam syn = new SynchronizedParam();
        new Thread(new Task(syn, A)).start();
        new Thread(new Task(syn, B)).start();

        // 主线程阻塞，防止jvm提早退出
        Thread.sleep(15000);
    }
}

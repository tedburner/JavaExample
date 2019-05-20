package com.example.test;

/**
 * @author: Arthas
 * @date: 2019-05-20 21:29
 * @description:
 */
public class Test1 {

    private long count = 0L;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() {
        try {
            final  Test1 test = new Test1();
            Thread th1 = new Thread(()->{
                test.add10K();
            });

            Thread th2 = new Thread(()->{
                test.add10K();
            });
            //启动线程
            th1.start();
            th2.start();

            //等待两个线程执行完毕
            th1.join();
            th2.join();

            return test.count;

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(calc());
    }
}

package com.example.common.keyword;

/**
 * @author lingjun.jlj
 * @date 2017-12-28
 **/
public class VolatileTest {

    private static volatile int race = 0;

    public static void increase() {
        race++;
    }

    public static void main(String[] args) {

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        //等所有累加线程结束
        while (Thread.activeCount() > 1)
            Thread.yield();

        System.out.println(race);
    }
}

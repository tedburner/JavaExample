package com.example.common.concurrent.lock;

import java.util.concurrent.CyclicBarrier;

/**
 * @author: Lucifer
 * @date: 2018/10/24 14:18
 * @description:
 */
public class CyclicBarrierTest {

    private static CyclicBarrier cyclicBarrier;

    static class CyclicBarrierThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "到了");
            //等待
            try {
                System.out.println("有多少人在等待" + cyclicBarrier.getNumberWaiting());
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("人到齐了，开会吧....");
            }
        });

        for (int i = 0; i < 5; i++) {
            new CyclicBarrierThread().start();
        }
    }
}

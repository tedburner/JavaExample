package com.example.basejava.concurrent.lock;

import java.util.concurrent.CyclicBarrier;

/**
 * @author: Lucifer
 * @date: 2018/10/24 14:18
 * @description:
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(1);
        //cyclicBarrier.await();
        cyclicBarrier.reset();
    }
}

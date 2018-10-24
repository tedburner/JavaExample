package com.example.basejava.concurrent.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: Lucifer
 * @date: 2018/10/24 14:01
 * @description:
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        //countDownLatch.await();
        //countDownLatch.await(1L, TimeUnit.MINUTES);
        countDownLatch.countDown();
    }
}

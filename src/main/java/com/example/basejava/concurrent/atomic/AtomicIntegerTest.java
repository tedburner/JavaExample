package com.example.basejava.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Lucifer
 * @date: 2018/11/21 14:03
 * @description:
 */
public class AtomicIntegerTest {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        count.addAndGet(1);
        System.out.println(count);
    }
}

package com.example.common.concurrent.atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author: Lucifer
 * @date: 2018/11/21 14:05
 * @description:
 */
public class LongAdderTest {

    public static void main(String[] args) {
        LongAdder adder = new LongAdder();
        adder.add(1L);
        System.out.println(adder);
    }
}

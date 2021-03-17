package com.example.common.concurrent.atomic;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author: lingjun.jlj
 * @date: 2018/11/21 14:05
 * @description: 在高并发情况下，LongAdder 比 AtomicLong 的性能高，LongAdder 引入了分段锁概念，
 * 不同线程在各自的分段内进行计算
 */
public class LongAdderTest {

    public static void main(String[] args) {
        LongAdder adder = new LongAdder();
        adder.add(1L);
        System.out.println(adder);
    }
}

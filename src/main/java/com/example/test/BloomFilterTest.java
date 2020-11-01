package com.example.test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;

/**
 * @author: lingjun.jlj
 * @date: 2018-11-27 09:49
 * @description: -Xms64m -Xmx64m -XX:+PrintHeapAtGC
 */
public class BloomFilterTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        BloomFilter filter = BloomFilter.create(
                Funnels.integerFunnel(),
                10000000,
                0.01
        );

        for (int i = 0; i < 10000000; i++) {
            filter.put(i);
        }

        Assert.assertTrue(filter.mightContain(1));
        Assert.assertTrue(filter.mightContain(100));
        Assert.assertTrue(filter.mightContain(10000));
        Assert.assertTrue(filter.mightContain(120000));
        long endTime = System.currentTimeMillis();

        System.out.println("执行时间：" + (endTime - startTime) + " ms");
    }

}

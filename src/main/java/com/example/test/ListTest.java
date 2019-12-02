package com.example.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/10/8 10:13
 * @description: 第一次添加发生了多次Full GC，导致时间比较长可以使用参数 -XX:+PrintGCDetails -XX:+PrintGCDateStamps 查看GC情况
 * 如果调大堆大小，但是还是会看到第一次的运行时间较长，是因为第一是使用的是解释模型，第二次升级使用了编译模型，JIT，这样运行速度相对比较快。
 */
public class ListTest {

    public static void main(String[] args) {
        int num0 = 10000000;
        int num1 = 20000000;
        List<Integer> list0 = new ArrayList<>();
        long start0 = System.currentTimeMillis();
        for (int i = 0; i < num0; i++) {
            list0.add(i);
        }
        System.out.println(System.currentTimeMillis() - start0);

        List<Integer> list1 = new ArrayList<>();
        long start1 = System.currentTimeMillis();
        for (int i = num0; i < num1; i++) {
            list1.add(i);
        }
        System.out.println(System.currentTimeMillis() - start1);
    }
}

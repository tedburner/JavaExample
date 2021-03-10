package com.example.test.collection;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/29 16:13
 * @description: Lists.partitions 以固定大小对数组进行切割
 */
public class ListPageCase {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int num = 100;
        for (int i = 0; i < num; i++) {
            list.add(i);
        }
        System.out.println(Lists.partition(list, 20));
    }
}

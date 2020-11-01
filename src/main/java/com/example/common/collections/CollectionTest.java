package com.example.common.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author lingjun.jlj
 * @create 2017-09-05
 **/
public class CollectionTest {

    public static void main(String[] args) {
        int num = 30000;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list1.add("test" + i);
            list2.add("test" + i * 3);
        }
        long start1 = System.currentTimeMillis();
        list1.retainAll(list2);
        System.out.printf("ArrayList: %d ms\n", (System.currentTimeMillis() - start1));

        List<String> list3 = new LinkedList<>();
        List<String> list4 = new LinkedList<>();
        for (int i = 0; i < num; i++) {
            list3.add("test" + i);
            list4.add("test" + i * 3);
        }
        long start2 = System.currentTimeMillis();
        list3.retainAll(list4);
        System.out.printf("LinkedList: %d ms\n", (System.currentTimeMillis() - start2));

        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < num; i++) {
            set1.add("test" + i);
            set2.add("test" + i * 3);
        }
        long start3 = System.currentTimeMillis();
        list3.retainAll(list4);
        System.out.printf("Set: %d ms\n", (System.currentTimeMillis() - start3));

    }
}

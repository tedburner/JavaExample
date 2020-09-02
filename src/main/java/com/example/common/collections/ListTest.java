package com.example.common.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lingjun.jlj
 * @data 2018/4/18
 * @Description:
 */
public class ListTest {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        LinkedList<Integer> linked = new LinkedList<>();
        //首先分别给两者插入10000条数据
        for (int i = 0; i < 100000; i++) {
            array.add(i);
            linked.add(i);
        }
        //获得两者随机访问的时间
        System.out.println("array get cost time:" + getTime(array));
        System.out.println("linked get cost time:" + getTime(linked));

        //获得在中间插入数据的时间
        System.out.println("array insert in first cost time:" + insertArrayListAtFirstTime(array));
        System.out.println("linked insert cost in first time:" + insertLinkedListAtFirstTime(linked));

        //获得在中间插入数据的时间
        System.out.println("array insert in middle cost time:" + insertInMiddleTime(array));
        System.out.println("linked insert cost in middle time:" + insertInMiddleTime(linked));

        //获得尾部插入数据的时间
        System.out.println("array insert at last cost time:" + insertAtLastTime(array));
        System.out.println("linked insert cost at last time:" + insertAtLastTime(linked));
    }

    //头插
    public static long insertArrayListAtFirstTime(List<Integer> list) {
        int num = 100000;
        long time = System.currentTimeMillis();
        for (int i = 1; i < num; i++) {
            list.add(0, i);
        }
        return System.currentTimeMillis() - time;
    }

    //头插
    public static long insertLinkedListAtFirstTime(LinkedList<Integer> list) {
        int num = 100000;
        long time = System.currentTimeMillis();
        for (int i = 1; i < num; i++) {
            list.addFirst(i);
        }
        return System.currentTimeMillis() - time;
    }

    //中间插入数据
    public static long insertInMiddleTime(List<Integer> list) {
        int num = 10000000; //表示要插入的数据量
        long time = System.currentTimeMillis();
        for (int i = 1; i < num; i++) {
            list.add(list.size() >> 1, i);
        }
        return System.currentTimeMillis() - time;
    }

    //尾插
    public static long insertAtLastTime(List<Integer> list) {
        int num = 1000000; //表示要插入的数据量
        long time = System.currentTimeMillis();
        for (int i = 1; i < num; i++) {
            list.add(i);
        }
        return System.currentTimeMillis() - time;
    }

    public static long getTime(List<Integer> list) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            int index = Collections.binarySearch(list, list.get(i));
            if (index != i) {
                System.out.println("ERROR!");
            }
        }
        return System.currentTimeMillis() - time;
    }
}

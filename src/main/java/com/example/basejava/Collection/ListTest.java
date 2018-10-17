package com.example.basejava.Collection;

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
        List<Integer> linked = new LinkedList<>();
        //首先分别给两者插入10000条数据
        for (int i = 0; i < 10000; i++) {
            array.add(i);
            linked.add(i);
        }
        //获得两者随机访问的时间
        System.out.println("array time:" + getTime(array));
        System.out.println("linked time:" + getTime(linked));
        //获得两者插入数据的时间
        System.out.println("array insert time:" + insertTime(array));
        System.out.println("linked insert time:" + insertTime(linked));
    }

    //插入数据
    public static long insertTime(List<Integer> list) {
        /*
         * 插入的数据量和插入的位置是决定两者性能的主要方面，
         * 我们可以通过修改这两个数据，来测试两者的性能
         */
        long num = 10000; //表示要插入的数据量
        int index = 700; //表示从哪个位置插入
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

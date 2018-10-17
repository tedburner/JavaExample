package com.example.basejava.collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author lingjun.jlj
 * @create 2017-09-18
 **/
public class SetTest {

    public static void main(String[] args) {
        //Set是无序的，不是按照插入的顺序排列的，不允许重复
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("b");
        set.add("a");
        System.out.println(set);

        Set<String> treeSet = new TreeSet<>();
    }
}

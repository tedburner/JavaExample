package com.example.basejava.collections;

import java.util.*;

/**
 * @author lingjun.jlj
 * @create 2017-09-05
 **/
public class CollectionTest {

    public static void main(String[] args) {
        //Set
        Set<String> set = new HashSet<>();
        set.add("abc");
        set.add("bcd");
        set.add("cde");
        set.add("abc");//自动去重

        for (Iterator it = set.iterator(); it.hasNext(); ) {
            System.out.println(it.next().toString());
        }
        //System.out.println(set.hashCode());
        List<String> list = new ArrayList<>();

        List<String> list1 = new LinkedList<>();


    }
}

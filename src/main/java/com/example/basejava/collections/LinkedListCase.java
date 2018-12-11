package com.example.basejava.collections;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Lucifer
 * @date: 2018-12-06 17:08
 * @description:
 */
public class LinkedListCase {

    public static void main(String[] args) {
        List<String> list =  new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list.get(0));
        System.out.println(((LinkedList<String>) list).getFirst());
        System.out.println(((LinkedList<String>) list).getLast());
    }
}

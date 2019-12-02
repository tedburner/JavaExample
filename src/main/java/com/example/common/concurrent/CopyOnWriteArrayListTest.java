package com.example.common.concurrent;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/6 11:09
 * @description:
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copy = new CopyOnWriteArrayList();
        copy.add("1");
        copy.set(1, "12");
        copy.get(1);
    }
}

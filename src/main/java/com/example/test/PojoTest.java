package com.example.test;

import com.example.programme.Query;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/21 14:29
 * @version：1.0
 * @description:
 */
public class PojoTest {

    public static void main(String[] args) {
        Query query = new Query();
        query.setQuery("toString");
        query.setStart(0);
        query.setSize(20);
        System.out.println(query);
    }
}

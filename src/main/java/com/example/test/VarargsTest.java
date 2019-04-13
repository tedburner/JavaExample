package com.example.test;

import java.util.Arrays;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2019/4/13 20:37
 * @description:
 */
public class VarargsTest {

    public static void fillFields(String... values) {
        List<String> list = Arrays.asList(values);
        list.forEach(System.out::println);
    }


    public static void main(String[] args) {
        fillFields("1", "2", "3", "4");
    }
}

package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/25 10:09
 * @description:
 */
public class Test {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(" " + i);
        }
        long size = list.size();
        System.out.println(Objects.equals(size, 10L));
    }
}

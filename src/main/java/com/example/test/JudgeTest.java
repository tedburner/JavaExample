package com.example.test;

import java.util.Objects;

/**
 * @author: Lucifer
 * @date: 2018-11-23 09:40
 * @description:
 */
public class JudgeTest {

    public static void main(String[] args) {

        int a = 1, b = 1;
        Boolean flag = !(Objects.equals(a, 1) || Objects.equals(b, 2));
        Boolean flag1 = !Objects.equals(a, 1) && !Objects.equals(b, 2);
        System.out.println(flag);
        System.out.println(flag1);
    }
}

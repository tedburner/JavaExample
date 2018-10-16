package com.example.test;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/16 13:51
 * @description:
 */
public class StringTest {

    public static void changeValue(String str) {
        str = str + "5";
    }

    public static void main(String[] args) {
        String str = "1234";
        changeValue(str);
        System.out.println(str);

    }
}

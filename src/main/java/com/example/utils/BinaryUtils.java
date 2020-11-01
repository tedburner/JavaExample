package com.example.utils;

/**
 * @author: lingjun.jlj
 * @date: 2018-12-19 17:08
 * @description:
 */
public class BinaryUtils {


    public static String toBinary(int num) {
        String str = "";
        while (num != 0) {
            str = num % 2 + str;
            num = num / 2;
        }
        return str;
    }

}

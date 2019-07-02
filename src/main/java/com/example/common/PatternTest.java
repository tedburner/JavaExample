package com.example.common;

import java.util.regex.Pattern;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/2 10:39
 * @version：1.0
 * @description: 正则匹配
 */
public class PatternTest {

    public static void main(String[] args) {
        String str = "[A-Za-z]";
        System.out.println(Pattern.matches(str, "abc"));
    }
}

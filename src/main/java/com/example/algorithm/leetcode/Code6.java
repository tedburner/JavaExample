package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2019/8/13 14:35
 * @description: Z 字形变换
 */
public class Code6 {

    public static void main(String[] args) {

    }

    public static String convert(String s, int numRows) {
        if (s.isEmpty() || s.length() == 1) {
            return s;
        }
        int len = s.length();
        int index = 0;
        Character[][] dp = new Character[len][4];
        for (int k = 0; k < numRows; k++) {
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(index);
            }
        }
        return "";
    }

}

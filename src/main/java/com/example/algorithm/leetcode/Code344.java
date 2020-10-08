package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/8 12:02
 * @description: 反转字符串
 * <href=https://leetcode-cn.com/problems/reverse-string/ />
 */
public class Code344 {

    public static void reverseString(char[] s) {
        int length = s.length;
        if (length == 0 || length == 1) {
            return;
        }
        for (int i = 0; i < length / 2; i++) {
            char ch = s[i];
            s[i] = s[length - i - 1];
            s[length - i - 1] = ch;
        }
    }

    public static void main(String[] args) {
//        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s);
        System.out.println(s);
    }

}

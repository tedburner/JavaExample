package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/10 17:13
 * @description: 最后一个单词的长度
 */
public class Code58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord(""));
    }

    public static int lengthOfLastWord(String s) {
        String[] array = s.split(" ");
        int len = array.length;
        if (len == 0) {
            return 0;
        }
        String last = array[len - 1];
        return last.length();
    }
}

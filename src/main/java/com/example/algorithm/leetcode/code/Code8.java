package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/2 10:46
 * @description: 字符串转换整数
 */
public class Code8 {

    public static void main(String[] args) {
        String str = "2147483648";
        System.out.println(myAtoi(str));
    }

    public static int myAtoi(String str) {
        String character = str.trim();
        if (character.isEmpty()) {
            return 0;
        }
        char firstChar = character.charAt(0);
        char flag = '+';
        int start = 0;
        if (firstChar == '-' || firstChar == '+') {
            flag = firstChar;
            start++;
        } else if (Character.isDigit(firstChar)) {
            flag = '+';
        } else {
            return 0;
        }
        int ans = 0;
        for (int i = start; i < character.length(); i++) {
            char c = character.charAt(i);
            //判断字符串是否是数字
            if (!Character.isDigit(c)) {
                break;
            }
            int num = c - '0';
            //需要判断如果加上当前这个数组，是否会越界
            if ((Integer.MAX_VALUE - num) / 10 < ans) {
                return flag == '+' ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + num;
        }
        return flag == '+' ? ans : -ans;

    }


}

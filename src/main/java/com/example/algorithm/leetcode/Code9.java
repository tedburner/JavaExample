package com.example.algorithm.leetcode;

import java.util.Objects;

/**
 * @author: Arthas
 * @date: 2019-07-26 21:58
 * @description: 回文数的判断
 */
public class Code9 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(2112));
    }

    public static boolean isPalindrome(int x) {
        //如果是负数或者末尾是0的，直接返回
        if (x < 0 || ((x % 10) == 0 && x != 0)) {
            return false;
        }
        int palindrome = 0;
        //当x小于palindrome，则x已经小于一半了
        while (x > palindrome) {
            palindrome = palindrome * 10 + x % 10;
            x = x / 10;
        }

        return Objects.equals(x, palindrome) || Objects.equals(x, palindrome / 10);
    }
}

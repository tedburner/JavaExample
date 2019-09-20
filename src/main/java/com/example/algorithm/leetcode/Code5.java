package com.example.algorithm.leetcode;

/**
 * @author: Arthas
 * @date: 2019-08-09 20:20
 * @description: 最长回文子串
 * https://www.jianshu.com/p/a7741619dd58
 */
public class Code5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abacab"));
        //System.out.println(isPalindrome("abcba"));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int max = -1;
        String res = "";
        for (int k = 0; k < len; k++) {
            for (int i = 0; k + i < len; i++) {
                int j = i + k;
                if (k == 0) {
                    dp[i][j] = true;
                } else if (k < 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) ? true : false;
                }
                if (j - i > max && dp[i][j]) {
                    max = j - i;
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }


    /**
     * 暴力求解，时间超时
     * 废弃
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        if (s.length() == 1 || s.isEmpty()) {
            return s;
        }
        if (s.length() == 2) {
            if (isPalindrome(s)) {
                return s;
            }
            return String.valueOf(s.charAt(0));
        }
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String ans = String.valueOf(s.charAt(i));
            for (int k = i + 1; k < s.length(); k++) {
                ans = s.substring(i, k + 1);
                if (isPalindrome(ans)) {
                    System.out.println(ans);
                    if (result.length() < ans.length()) {
                        result = ans;
                    }
                }
            }
        }
        if (result.isEmpty()) {
            return String.valueOf(s.charAt(0));
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length() / 2; i++) {
            System.out.println(s.charAt(i) + "==" + s.charAt(s.length() - i - 1));
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}

package com.example.algorithm.LeetCode;

/**
 * @author: Arthas
 * @date: 2019-08-09 20:20
 * @description: 最长回文子串
 * https://www.jianshu.com/p/a7741619dd58
 */
public class Code5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aba"));
        //System.out.println(isPalindrome("abcba"));
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return s;
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        for (int i = len - 2; i >= 0; i--) {
            dp[i][i] = true;
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);//小于3是因为aba一定是回文
                if (dp[i][j] && start - end < j - i) {
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end + 1);
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

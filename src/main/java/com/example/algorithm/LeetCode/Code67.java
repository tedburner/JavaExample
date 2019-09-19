package com.example.algorithm.LeetCode;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/19 14:35
 * @description: 二进制求和
 */
public class Code67 {

    public static void main(String[] args) {
        String result = "";
        Code67 code = new Code67();
        code.back(result, "10", "10", 0);
        System.out.println();
    }

    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1, len2);
        int aLen1 = len1, aLen2 = len2;
        int advance = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (len > len1) {

            } else if (len > len2) {

            } else {
                String c = a.substring(len1 - 1, len1);
            }
        }
        return "";
    }

    public void back(String result, String str1, String str2, int advance) {
        System.out.println(result);
        int len1 = str1.length();
        int len2 = str2.length();
        if (len1 == 0) {
            back(result + advance, "", str2.substring(0, len2 - 1), 1);
        }
        String character1 = str1.substring(len1 - 1, len1);
        String character2 = str2.substring(len2 - 1, len2);
        int sum = Integer.valueOf(character1) + Integer.valueOf(character2) + advance;
        if (sum > 2) {
            int nowNum = sum - 2;
            back(result + nowNum, str1.substring(0, len1 - 1), str2.substring(0, len2 - 1), 1);
        } else {
            back(result + sum, str1.substring(0, len1 - 1), str2.substring(0, len2 - 1), 0);
        }
    }
}

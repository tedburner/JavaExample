package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/19 14:35
 * @description: 二进制求和
 */
public class Code67 {

    public static void main(String[] args) {
        Code67 code = new Code67();
        System.out.println(code.addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int len = Math.max(len1, len2);
        StringBuilder result = new StringBuilder();
        //对二进制补齐
        while (a.length() != b.length()) {
            if (len > len1) {
                a = "0" + a;
            }else {
                b = "0" + b;
            }
        }
        System.out.println("a:" + a + "; b:" + b);
        int x = 0, y = 0, sum = 0, pre = 0;
        for (int i = len - 1; i >= 0; i--) {
            x = a.charAt(i) - '0';
            y = b.charAt(i) - '0';
            sum = x + y + pre;
            if (sum >= 2) {
                pre = 1;
                result.append(sum - 2);
            } else {
                pre = 0;
                result.append(sum);
            }
        }
        if (pre == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}

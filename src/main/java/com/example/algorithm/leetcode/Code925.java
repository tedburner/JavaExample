package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/21 15:53
 * @description: 长按键入
 * <p>
 * 思路：双指针
 */
public class Code925 {

    public static boolean isLongPressedName(String name, String typed) {
        int n = name.length();
        int m = typed.length();
        if (n > m) {
            return false;
        }
        int p = 0, q = 0;
        while (q < m) {
            if (p < name.length() && name.charAt(p) == typed.charAt(q)) {
                p++;
                q++;
            } else if (p > 0 && typed.charAt(q) == name.charAt(p - 1)) {
                q++;
            } else {
                return false;
            }
        }
        return p == n;
    }

    public static void main(String[] args) {
        String name = "alex", typed = "alexxr";
        System.out.println(isLongPressedName(name, typed));
    }
}

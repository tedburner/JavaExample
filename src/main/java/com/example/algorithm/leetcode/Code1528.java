package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/15 21:33
 * @description: 重新排列字符串
 */
public class Code1528 {

    public String restoreString(String s, int[] indices) {
        int length = s.length();
        char[] result = new char[length];
        for (int i = 0; i < length; i++) {
            result[indices[i]] = s.charAt(i);
        }
        return new String(result);
    }

    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4, 5, 6, 7, 0, 2, 1, 3};
        System.out.println(new Code1528().restoreString(s, indices));
    }
}

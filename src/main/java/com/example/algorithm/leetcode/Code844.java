package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/19 13:33
 * @description: 比较含退格的字符串
 * <p>
 * 思路1：使用StringBuilder 重新构建字符串，然后比较重构后的字符串是否相等
 */
public class Code844 {

    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (ch == '#') {
                if (builder.length() > 0) {
                    builder.deleteCharAt(builder.length() - 1);
                }
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String S = "a#c";
        String T = "b";
        System.out.println(new Code844().backspaceCompare(S, T));
    }
}

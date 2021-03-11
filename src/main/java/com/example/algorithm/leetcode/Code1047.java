package com.example.algorithm.leetcode;

import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/11 10:39
 * @description: 删除字符串中的所有相邻重复项
 * 思路：通过堆栈，来判断堆栈首位和字符下一位是否一致
 * stack.peek();不移出的前提下，获取首位数据
 */
public class Code1047 {

    public static String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i++) {
            Character ch = S.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                Character top = stack.peek();
                if (top == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        StringBuffer buffer = new StringBuffer();
        for (Character ch : stack) {
            buffer.append(ch);
        }
        return buffer.toString();
    }

    public static void main(String[] args) {
        String s = "a";
        String result = removeDuplicates(s);
        System.out.println(result);
    }
}

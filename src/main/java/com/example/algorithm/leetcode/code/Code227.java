package com.example.algorithm.leetcode.code;


import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/11 10:56
 * @description: 基本计算器 II
 * 思路：使用栈，如果加号，压入；减号，取反压入；乘除，和堆栈中首位数字处理后压入堆栈，然后计算堆栈中的数据
 */
public class Code227 {

    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = s.length();
        char preSign = '+';
        int num = 0;
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            // 当前字符是个数字，转化成数字
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            // 如果不等于数字，则为特殊字符，且不是空格
            if (!Character.isDigit(ch) && ch != ' ' || i == length - 1) {
                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(-num);
                } else if (preSign == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
                preSign = ch;
                num = 0;
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
    }
}

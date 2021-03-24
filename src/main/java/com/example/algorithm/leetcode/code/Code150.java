package com.example.algorithm.leetcode.code;

import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/20 22:18
 * @description: 逆波兰表达式求值
 * 逆波兰式，将运算符写在操作数之后
 * <p>
 * 思路：使用栈功能，如果碰到预算法，则，去除队首两位运算后，压入栈中
 */
public class Code150 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int backNum = stack.pop();
                int frontNum = stack.pop();
                if ("+".equals(token)) {
                    stack.push(frontNum + backNum);
                } else if ("-".equals(token)) {
                    stack.push(frontNum - backNum);
                } else if ("*".equals(token)) {
                    stack.push(frontNum * backNum);
                } else if ("/".equals(token)) {
                    stack.push(frontNum / backNum);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }
}

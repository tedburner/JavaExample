package com.example.algorithm.leetcode.code;

import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2021/4/14 22:37
 * @description: 笨阶乘
 * <p>
 * 通过一个标记位，标识循环进行乘除加减，计算需要考虑乘除加减的优先级。
 * 关于计算器思路参考{@link Code227}，思路就是对于乘除，去栈栈首数字先进行乘除，然后在压入栈；如果是减法，数据取反后压入
 */
public class Code1006 {

    public static int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int num = N;
        stack.push(num);
        while (--num > 0) {
            if (index % 4 == 0) {
                stack.push(stack.pop() * num);
            } else if (index % 4 == 1) {
                stack.push(stack.pop() / num);
            } else if (index % 4 == 2) {
                stack.push(num);
            } else {
                stack.push(-num);
            }
            index++;
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(clumsy(4));
    }
}

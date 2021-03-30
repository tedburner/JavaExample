package com.example.algorithm.mianshi;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2020/12/9 10:53
 * @description: 阿里面试——字母消消乐
 * 利用堆栈实现
 */
public class CharReplace {

    public static void main(String[] args) {
        //System.out.println("字母消消乐结果：" + eliminateStr("aA"));
        System.out.println("字母消消乐结果：" + eliminateStr("abBA"));
    }

    public static String eliminateStr(String str) {
        if (str.length() < 2) {
            return str;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                int top = stack.peek();
                if (top == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }
        char[] ans = new char[stack.size()];
        int num = stack.size() - 1;
        while (!stack.isEmpty()) {
            ans[num--] = stack.pop();
        }
        return Arrays.toString(ans);
    }
}

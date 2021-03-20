package com.example.algorithm.leetcode.code;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2019-07-27 23:18
 * @description: 有效的括号，使用栈来计算
 */
public class Code20 {

    public static void main(String[] args) {
        System.out.println(isValid("(([]){})"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 1 || s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.empty() ? '@' : stack.pop();
                if (topElement != map.get(c)) {
                    return false;
                }
            } else {
                //如果截取的元素不在map中，则加入队列
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}

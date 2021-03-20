package com.example.algorithm.leetcode.code;

import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/17 22:50
 * @description: 验证二叉树的前序序列化
 * 思路：利用堆栈，对于叶子节点，他的两个节点都是空节点， X##，X## => # 进行消除数据，最后数据为 #，表示其是二叉树的前序序列化
 */
public class Code331 {

    public static boolean isValidSerialization(String preorder) {
        String[] array = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for (String str : array) {
            stack.push(str);
            // 如果栈顶的两位是 # ，且第三位不是 # 消除
            while (stack.size() >= 3 && "#".equals(stack.get(stack.size() - 1))
                    && "#".equals(stack.get(stack.size() - 2)) && !"#".equals(stack.get(stack.size() - 3))) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");

            }
        }
        return stack.size() == 1 && "#".equals(stack.peek());
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("1,#,#,#,#"));
    }
}

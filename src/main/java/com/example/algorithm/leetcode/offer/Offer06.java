package com.example.algorithm.leetcode.offer;

import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/26 14:17
 * @description: 剑指 Offer 06. 从尾到头打印链表
 */
public class Offer06 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode node = head;
        int total = 0;
        while (node != null) {
            stack.push(node.val);
            node = node.next;
            total++;
        }
        int[] ans = new int[total];
        int i = 0;
        while (!stack.isEmpty()) {
            int num = stack.pop();
            ans[i++] = num;
        }
        return ans;

    }
}

package com.example.algorithm.leetcode.code;

import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/25 17:02
 * @description: 两数相加 II
 */
public class Code445 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        //遍历l1
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        //遍历l2
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode ans = new ListNode(0);
        //两数想加
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = !stack1.isEmpty() ? stack1.pop() : 0;
            int num2 = !stack2.isEmpty() ? stack2.pop() : 0;
            int sum = num1 + num2 + ans.val;
            ListNode node = new ListNode(sum % 10);
            ans.val = sum / 10;
            //构建链表
            ListNode next = ans.next;
            ans.next = node;
            node.next = next;
        }
        // 如果高位满足10，补一位
        return ans.val > 0 ? ans : ans.next;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }
}

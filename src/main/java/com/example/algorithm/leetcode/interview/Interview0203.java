package com.example.algorithm.leetcode.interview;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/25 16:49
 * @description:
 */
public class Interview0203 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void deleteNode(ListNode node) {
        // 计算链表长度
        int total = 0;
        ListNode head = node;
        while (head.next != null) {
            total++;
            head = head.next;
        }
        ListNode current = node;
        for (int i = 0; i < (total / 2)-1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
    }
}

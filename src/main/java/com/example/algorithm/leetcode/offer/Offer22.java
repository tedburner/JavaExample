package com.example.algorithm.leetcode.offer;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/18 21:42
 * @description: 剑指 Offer 22. 链表中倒数第k个节点
 * 思路，快慢指针思想
 */
public class Offer22 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode quick = head;
        ListNode slow = head;
        // 快指针先走K步
        for (int i = 0; i < k; i++) {
            quick = quick.next;
        }
        // 快慢指针一起走，当快指针走完结束
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            ListNode next = new ListNode(i);
            node.next = next;
            node = node.next;
        }
        ListNode node1 = getKthFromEnd(head, 2);
        System.out.println(node1);
    }
}

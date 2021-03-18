package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/18 20:42
 * @description: 反转链表 II
 */
public class Code92 {

    public static class ListNode {
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

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode ansNode = new ListNode(-1);
        ansNode.next = head;
        ListNode pre = ansNode;
        //循环遍历至left前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 需要反转的第一个节点
        ListNode current = pre.next;
        ListNode next;
        // 链表反转，遍历插入，遍历到当前节点，插入到起始节点上
        for (int i = left; i < right; i++) {
            next = current.next;
            current.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return ansNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            ListNode next = new ListNode(i);
            node.next = next;
            node = node.next;
        }
        ListNode result = reverseBetween(head, 2, 4);
        System.out.println(result);
    }
}

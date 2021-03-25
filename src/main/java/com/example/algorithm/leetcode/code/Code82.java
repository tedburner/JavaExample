package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/25 16:29
 * @description: 删除排序链表中的重复元素 II
 */
public class Code82 {

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

    public static ListNode deleteDuplicates(ListNode head) {
        //添加一个节点
        ListNode dummy = new ListNode(-1, head);
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            // 如果下个节点和下下个节点值相同，则删除相同的元素
            if (current.next.val == current.next.next.val) {
                int n = current.next.val;
                while (current.next != null && current.next.val == n) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1));
        ListNode result = deleteDuplicates(head);
        System.out.println(result);
    }
}

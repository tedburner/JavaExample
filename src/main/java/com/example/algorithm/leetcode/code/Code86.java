package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/5/7 22:04
 * @description: 分隔链表
 * 思路：添加2个链表，分别存储小于 x 和大于等于 x 链表数据，遍历 head 链表，将链表上的数据分别存储到2个链表上，最后重新合并链表。
 */
public class Code86 {
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

    public static ListNode partition(ListNode head, int x) {
        ListNode large = new ListNode(0);
        ListNode small = new ListNode(0);
        ListNode largeHead = large;
        ListNode smallHead = small;
        while (head != null) {
            int val = head.val;
            if (val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;

        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode result = partition(head, 3);
        System.out.println(result);
    }

}

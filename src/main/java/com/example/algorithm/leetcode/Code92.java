package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/18 19:20
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
        int i = 1;
        ListNode currentNode = head;
        while (currentNode.next != null) {
            ListNode pre = currentNode;
            while (i >= left && i <= right) {
                ListNode node = currentNode.next;
                currentNode.next = pre;
                pre = currentNode;
                currentNode = node;
                i++;
            }
            currentNode = currentNode.next;
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = reverseBetween(head, 2,4);
        System.out.println(node);
    }

}

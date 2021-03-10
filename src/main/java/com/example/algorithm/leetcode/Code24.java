package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/13 09:57
 * @description: 两两交换链表中的节点
 */
public class Code24 {

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

    public ListNode swapPairs(ListNode head) {
        //添加临时头节点
        ListNode first = new ListNode(0, head);
        ListNode node = first;
        while (node.next != null && node.next.next != null) {
            //链表节点交换
            ListNode one = node.next;
            ListNode two = node.next.next;
            ListNode three = node.next.next.next;
            node.next = two;
            one.next = three;
            two.next = one;
            node = one;
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i < 5; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;
        }
        ListNode node = new Code24().swapPairs(head);
        System.out.println(node);
    }
}

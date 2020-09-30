package com.example.algorithm.leetcode;


/**
 * @author: lingjun.jlj
 * @date: 2020/9/30 14:23
 * @description: 反转链表
 */
public class Code206 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;//上一个节点
        ListNode current = head;//当前节点
        while (current != null) {
            //下个节点，当前节点和上一个节点进行交换
            ListNode node = current.next;
            current.next = pre;
            pre = current;
            current = node;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i = 2; i < 6; i++) {
            ListNode node = new ListNode(i);
            current.next = node;
            current = node;
        }
        ListNode node = new Code206().reverseList(head);
        System.out.println(node);
    }
}

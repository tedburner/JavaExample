package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/18 21:51
 * @description: 旋转链表
 * 思路：找到倒数第 K个节点，然后断开，链表尾部节点连接头节点
 */
public class Code61 {

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

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode oldNode = head;
        // 链表形成闭环并计算链表长度
        int size = 1;
        while (oldNode.next != null) {
            oldNode = oldNode.next;
            size++;
        }
        oldNode.next = head;

        // 遍历寻找新的表头和表尾，循环链表循环遍历一次后
        // 注意K的大小可能大于链表长度
        ListNode current = head;
        for (int i = 0; i < size - k % size - 1; i++) {
            current = current.next;
        }
        ListNode newNode = current.next;
        //打开闭环
        current.next = null;

        return newNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            ListNode next = new ListNode(i);
            node.next = next;
            node = node.next;
        }

        System.out.println(rotateRight(head, 2));
    }

}

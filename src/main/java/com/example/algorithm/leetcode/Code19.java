package com.example.algorithm.leetcode;

import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/18 14:26
 * @description: 删除链表的倒数第N个节点
 * <p>
 * 思路1：计算链表长度，然后遍历到倒数位置，删除指定倒数位置。
 * <p>
 * 思路2：利用栈，删除指定的倒数位置
 * <p>
 * 问题：当要删除第一个节点时，需要如何处理。通过增加一个头结点，来处理需要删除第一个节点的问题
 */
public class Code19 {

    public class ListNode {
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

    /**
     * 链表计数遍历
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0, head);
        int length = getLength(head);
        ListNode currentNode = first;
        for (int i = 0; i < length - n + 1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        return first.next;
    }

    public int getLength(ListNode head) {
        int length = 0;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        return length;
    }


    /**
     * 栈处理链表
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEndByStack(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode first = new ListNode(0, head);
        ListNode currentNode = first;
        while (currentNode != null) {
            stack.push(currentNode);
            currentNode = currentNode.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        return first.next;
    }

    public static void main(String[] args) {

    }

}

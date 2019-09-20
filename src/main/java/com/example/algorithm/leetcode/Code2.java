package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Arthas
 * @date: 2019-03-16 16:46
 * @description: 两数相加
 */
public class Code2 {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node111 = new ListNode(3);
        node1.next = node11;
        node11.next = node111;

        ListNode node2 = new ListNode(5);
        ListNode node22 = new ListNode(6);
        ListNode node222 = new ListNode(4);
        node2.next = node22;
        node22.next = node222;

        ListNode node = addTwoNumbers(node1, node2);
        System.out.println(count(node));

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int count(ListNode node) {
        int number = 0;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        for (int i = list.size() - 1; i >= 0; i--) {
            number = number * 10 + list.get(i);
        }
        return number;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        int carry = 0;
        ListNode newhead = new ListNode(-1);
        ListNode l3 = newhead;

        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            l3.next = new ListNode(carry % 10);
            carry = carry / 10;
            l3 = l3.next;
        }

        if (carry == 1)
            l3.next = new ListNode(1);
        return newhead.next;

    }

}


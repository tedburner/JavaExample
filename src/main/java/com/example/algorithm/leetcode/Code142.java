package com.example.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/10 09:47
 * @description: 环形链表 II
 */
public class Code142 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 使用Hash判断是否已经使用过该节点
     *
     * @param head 头结点
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> hash = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (hash.contains(node)) {
                return node;
            } else {
                hash.add(node);
            }
            node = node.next;
        }
        return null;
    }

    /**
     * 快慢指针
     *
     * @param head 头结点
     * @return
     */
    public ListNode detectCycleByFastAndSlow(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }
}

package com.example.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/9 09:47
 * @description: 环形链表
 */
public class Code141 {

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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> hash = new HashSet<>();
        while (head != null) {
            if (!hash.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针，快指针每次移动2步，慢指针每次移动一步，如果在移动的过程中，快指针反过来追上慢指针，就说明该链表为环形链表。否则快指针将到达链表尾部，
     * 该链表不为环形链表。
     * <p>
     * 空间复杂度O(1)，时间复杂度O(n)
     *
     * @param head 头结点
     * @return
     */
    public boolean hasCycleByFastAndSlow(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }


    public static void main(String[] args) {

    }
}

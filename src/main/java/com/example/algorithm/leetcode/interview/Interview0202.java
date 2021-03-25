package com.example.algorithm.leetcode.interview;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/18 21:34
 * @description: 02.02. 返回倒数第 k 个节点
 * <href = https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci />
 * 思路1：2次遍历，第一次计算链表大小，第二次计算倒数第二个位置
 * <p>
 * 思路2：快慢指针，快指针先走K步，然后快慢指针一起遍历，当快指针遍历到末尾的时候，慢指针的位置就是我们需要的位置。
 * 快慢指针实现逻辑{@link com.example.algorithm.leetcode.offer.Offer22}
 */
public class Interview0202 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static int kthToLast(ListNode head, int k) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        ListNode next = head;
        for (int i = 0; i < size - k; i++) {
            next = next.next;
        }
        return next.val;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i <= 5; i++) {
            ListNode next = new ListNode(i);
            node.next = next;
            node = node.next;
        }

        System.out.println(kthToLast(head, 2));
    }

}

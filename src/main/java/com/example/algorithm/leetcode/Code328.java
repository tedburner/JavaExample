package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/14 14:58
 * @description: 奇偶链表，节点奇偶性，如果第一个节点是奇数，则第二个节点是偶数，以此类推
 * <p>
 * 思路：分离节点后，合并，将奇偶节点分离，然后合并链表
 */
public class Code328 {

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

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //奇数节点
        ListNode odd = head;
        //偶数头结点
        ListNode even = head.next;
        //偶数的尾节点
        ListNode last = even;
        while (odd.next != null && even.next != null) {
            //奇数节点和偶数节点互换
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = odd.next;
        }
        odd.next = last;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        oddEvenList(head);
        System.out.println(head);
    }
}

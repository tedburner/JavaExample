package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/12 15:23
 * @description: 删除排序链表中的重复元素
 * 思路：因为是有序列表，所以比较相邻的节点，如果下个节点和当前节点相同，就删除下个节点
 */
public class Code83 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null){
            //判断当前链表和下一个节点是否相同
            if (node.val == node.next.val){
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        ListNode result = deleteDuplicates(head);
        System.out.println(result);

    }
}

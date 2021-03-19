package com.example.algorithm.problem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/30 14:57
 * @description: 面试题 04.03. 特定深度节点链表
 * <href = https://leetcode-cn.com/problems/list-of-depth-lcci//>
 */
public class Code0403 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<ListNode> result = new ArrayList<>();
        queue.offer(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode head = null;
            ListNode current = null;
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
                if (i == 0) {
                    current = new ListNode(treeNode.val);
                    head = current;
                } else {
                    ListNode node = new ListNode(treeNode.val);
                    current.next = node;
                    current = node;
                }
            }
            result.add(head);
        }
        ListNode[] array = new ListNode[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        ListNode[] array = new Code0403().listOfDepth(root);
        System.out.println(array);
    }
}

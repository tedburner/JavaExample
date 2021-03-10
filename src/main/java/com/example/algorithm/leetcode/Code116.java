package com.example.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/15 09:31
 * @description: 填充每个节点的下一个右侧节点指针
 * <p>
 * 思路：二叉树的层次遍历，不过从右子树往左子树遍历，这样上一个节点就是下一个节点的右节点了
 */
public class Code116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                node.next = pre;
                pre = node;
            }
        }
        return root;
    }
}

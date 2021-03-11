package com.example.algorithm.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/28 09:29
 * @description: 填充每个节点的下一个右侧节点指针 II
 * 思路：BFS，广度遍历二叉树的每一层，遍历每一层节点。每一层遍历，定义上一个节点为null，从右往左遍历每一层节点，上一个节点就是
 * 当前节点的右侧节点，直接指向上一个节点就好了。
 */
public class Code117 {

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
            //每一层节点数
            int size = queue.size();
            //上一个节点
            Node lastNode = null;
            for (int i = 1; i <= size; i++) {
                Node node = queue.poll();
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                node.next = lastNode;
                lastNode = node;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        new Code117().connect(root);
        System.out.println(root);
    }
}

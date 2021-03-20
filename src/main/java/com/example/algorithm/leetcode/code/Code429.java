package com.example.algorithm.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/12 22:06
 * @description: N叉树的层序遍历
 */
public class Code429 {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> floor = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                floor.add(node.val);
                if (node.children != null) {
                    for (Node children : node.children) {
                        queue.offer(children);
                    }
                }
            }
            result.add(floor);
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1, new ArrayList<>());
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> _children = Arrays.asList(node5, node6);
        root.children.add(new Node(3, _children));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        System.out.println(levelOrder(root));
    }
}

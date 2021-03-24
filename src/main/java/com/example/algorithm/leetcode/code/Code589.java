package com.example.algorithm.leetcode.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/30 15:39
 * @description: N叉树的前序遍历 <href = https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/>
 */
public class Code589 {

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

    /**
     * 使用递归前序遍历多叉树
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    public void inorder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children == null) {
            return;
        }
        for (Node node : root.children) {
            inorder(node, list);
        }
    }


    /**
     * 使用stack来实现
     *
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.add(node.val);
            if (node.children != null) {
                //将子节点反转，使得右子树先入队，然后从右往左，一次入队
                Collections.reverse(node.children);
                for (Node item : node.children) {
                    stack.add(item);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(1, new ArrayList<>());
        Node node2 = new Node(2);
        Node node3 = new Node(2);
        Node node6 = new Node(6);
        List<Node> _children = Arrays.asList(node2, node3, node6);
        root.children.add(new Node(3, _children));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        System.out.println(new Code589().preorder(root));
    }
}

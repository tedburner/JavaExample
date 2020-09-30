package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/30 15:39
 * @description: N叉树的前序遍历 <href = https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/>
 */
public class Code589 {

    class Node {
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
    public List<Integer> preorder(Node root) {
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
}

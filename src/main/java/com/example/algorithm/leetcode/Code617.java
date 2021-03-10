package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/23 15:45
 * @description: 合并二叉树
 * 思路：递归深度搜索同时遍历两颗二叉树，如果两棵树的节点都不为null，就想加作为新节点，否则不为Null的为新节点值
 */
public class Code617 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}

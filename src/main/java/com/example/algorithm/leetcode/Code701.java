package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/30 09:54
 * @description: 二叉搜索树中的插入操作
 * 思路：二叉搜索树是一棵有序的二叉树，根节点和插入数据比对，进行递归，查询到需要插入的叶子节点
 */
public class Code701 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val == val) {
            return root;
        }
        //根节点大于插入节点，遍历左子树
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}

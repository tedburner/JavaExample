package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/30 14:16
 * @description: 二叉搜索树中的搜索
 */
public class Code700 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        TreeNode node = null;
        if (root.val == val) {
            node = root;
        } else if (root.val > val) {
            node = searchBST(root.left, val);
        } else {
            node = searchBST(root.right, val);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode node = new Code700().searchBST(root, 2);
        System.out.println(node);
    }

}

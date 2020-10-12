package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/12 09:18
 * @description: 二叉搜索树的最小绝对差
 * 思路：二叉搜索树的中序遍历，一个有序数组
 */
public class Code530 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int min;
    int pre;

    public int getMinimumDifference(TreeNode root) {
        min = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            min = Math.min(min, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }

    public static void main(String[] args) {

    }
}

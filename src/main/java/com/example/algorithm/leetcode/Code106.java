package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/25 10:15
 * @description: 从中序与后序遍历序列构造二叉树
 * 思路：根据后续遍历根节点，递归来切割中序遍历的数组
 */
public class Code106 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return new TreeNode(1);
    }

    public static void main(String[] args) {

    }
}

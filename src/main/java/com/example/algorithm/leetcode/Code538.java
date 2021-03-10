package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/21 09:14
 * @description: 把二叉搜索树转换为累加树
 * 描述：给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它
 * 的节点值之和
 * 二叉搜索树特性：
 * 1、的根节点，大于左子树，小于右子树
 * <p>
 * 思路：二叉搜索树的中序遍历，刚好是一个从小到大排列的有序数据，如果将中序遍历的数据反正，从大到小排列，只需要进行累加就行
 */
public class Code538 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
        new Code538().convertBST(root);
        System.out.println(root);
//        TreeNode root = new TreeNode(7);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(5);
//        root.left.right.left = new TreeNode(4);
//        root.right = new TreeNode(11);
//        root.right.left = new TreeNode(10);
//        root.right.right = new TreeNode(15);
//        new Code538().convertBST(root);
//        System.out.println(root);
    }

    /**
     * 先序遍历
     * <p>
     * 先序遍历先从二叉树的根开始，然后到左子树，再到右子树
     *
     * @param node 遍历的节点
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        System.out.print(node.val + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     * <p>
     * 后序遍历先从左子树开始，然后到右子树，再到根
     *
     * @param node 遍历的节点
     */
    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.val + " ");
    }
}
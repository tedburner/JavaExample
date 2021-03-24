package com.example.algorithm.leetcode.code;

import java.util.Arrays;

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

    public int findNodeIndex(int[] inorder, int rootVal) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        int length = postorder.length;
        int rootVal = postorder[length - 1];
        //获取中序遍历根节点位置
        int rootIndex = findNodeIndex(inorder, rootVal);
        TreeNode root = new TreeNode(rootVal);
        //构建左子树
        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] leftPostOrder = Arrays.copyOfRange(postorder, 0, rootIndex);
        root.left = buildTree(leftInOrder, leftPostOrder);
        //构建右子树
        int[] rightInOrder = Arrays.copyOfRange(inorder, rootIndex + 1, inorder.length);
        int[] rightPostOrder = Arrays.copyOfRange(postorder, rootIndex, postorder.length - 1);
        root.right = buildTree(rightInOrder, rightPostOrder);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{2, 3, 1};
        int[] postorder = new int[]{3, 2, 1};
        TreeNode root = new Code106().buildTree(inorder, postorder);
        System.out.println(root);
    }
}

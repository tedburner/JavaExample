package com.example.algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/14 09:43
 * @description: 二叉树的中序遍历
 */
public class Code94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        middle(root, result);
        return result;
    }

    public void middle(TreeNode root, List<Integer> result) {
        if (root == null){
            return;
        }
        middle(root.left, result);
        result.add(root.val);
        middle(root.right, result);
    }

    public static void main(String[] args) {
        Code94 code = new Code94();
        TreeNode root =  new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(code.inorderTraversal(root));
    }
}

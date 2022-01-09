package com.example.algorithm.leetcode.code;

import org.apache.poi.ss.formula.functions.T;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lingjun.jlj
 * @date: 2021/11/16 22:05
 * @description: 路径总和
 * <p>
 * 思路：二叉树的广度搜索，每个节点累加，看最后的节点，是否有和目标值相同的
 */
public class Code112 {
    public static class TreeNode {
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

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int temp = node.val;
            if (node.right == null && node.left == null) {
                if (temp == targetSum) {
                    return true;
                }
                continue;
            }
            if (node.right != null) {
                node.right.val = node.right.val + temp;
                queue.offer(node.right);
            }

            if (node.left != null) {
                node.left.val = node.left.val + temp;
                queue.offer(node.left);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(hasPathSum(root, 3));
    }
}

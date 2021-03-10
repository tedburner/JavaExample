package com.example.algorithm.leetcode;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/12 21:05
 * @description: 二叉树的最小深度
 * 方法一，深度遍历到根节点
 * 方法二：广度遍历每一层
 */
public class Code111 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 深度搜索遍历每一层
     *
     * @param root 根节点
     * @return
     */
    public static int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(min_depth, minDepth(root.left));
        }
        if (root.right != null) {
            min_depth = Math.min(min_depth, minDepth(root.right));
        }

        return min_depth + 1;
    }

    /**
     * 广度搜索遍历每一层
     *
     * @param root 根节点
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int result = 0, index = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            index++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.right == null && node.left == null) {
                    if (result == 0 || index < result) {
                        result = index;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(minDepth1(root));
    }
}

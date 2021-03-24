package com.example.algorithm.leetcode.code;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/19 15:39
 * @description: 左叶子之和
 * 思路：深度遍历根节点的左右节点的左叶子节点
 */
public class Code404 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root);
    }

    /**
     * 深度遍历
     */
    private int dfs(TreeNode root) {
        int ans = 0;
        //遍历根节点左子树
        if (root.left != null) {
            ans += isLeftNode(root.left) ? root.left.val : dfs(root.left);
        }
        //遍历根节点右子树
        if (root.right != null && !isLeftNode(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }

    /**
     * 判断节点是否是叶子节点
     */
    private boolean isLeftNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Code404().sumOfLeftLeaves(root));
    }


}

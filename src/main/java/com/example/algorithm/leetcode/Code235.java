package com.example.algorithm.leetcode;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/27 09:39
 * @description: 二叉搜索树的最近公共祖先
 * 思路：二叉搜索树的中序遍历是有序数组。如果根节点大于p,q，则公共祖先在左子树；如果根节点小于p,q，则公共祖先在右子树；否则返回根节点。
 */
public class Code235 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //根节点大于p,q，则遍历左节点
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //根节点小于p,q，则遍历右节点
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}

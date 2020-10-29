package com.example.algorithm.leetcode;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author: lingjun.jlj
 * @date: 2020/10/29 16:10
 * @description: 求根到叶子节点数字之和
 */
public class Code129 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Set<TreeNode> set = new HashSet<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                node.left.val = node.val * 10 + node.left.val;
                queue.offer(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val * 10 + node.right.val;
                queue.offer(node.right);
            }
            if (node.left == null && node.right == null) {
                set.add(node);
            }
        }
        int ans = 0;
        for (TreeNode node : set) {
            ans += node.val;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        System.out.println(sumNumbers(root));
    }
}

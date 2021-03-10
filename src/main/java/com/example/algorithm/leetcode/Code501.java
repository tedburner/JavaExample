package com.example.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/24 09:44
 * @description: 二叉搜索树中的众数
 * 思路：二叉搜索树是一棵有序的二叉树，中序遍历，是一个有序数组，所以对于众数，是连续出现的
 */
public class Code501 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int currentCount = 0; //当前节点出现次数
    int currentVal = 0; //当前节点val值
    int maxCount = 0; //最大出现次数
    List<Integer> list = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        bst(root);
        int[] ans = new int[list.size()];
        int i = 0;
        for (Integer value : list) {
            ans[i++] = value;
        }
        return ans;
    }

    public void bst(TreeNode root) {
        if (root == null) {
            return;
        }
        bst(root.left);
        //当前节点操作
        int currentNode = root.val;
        //判断当前节点是否和上一个节点一致
        if (currentNode == currentVal) {
            currentCount++;
        } else {
            currentVal = currentNode;
            currentCount = 1;
        }
        if (currentCount == maxCount) {
            list.add(currentNode);
        } else if (currentCount > maxCount) {
            //如果当前节点次数大于最大次数，清空之前的节点
            list.clear();
            list.add(currentNode);
            maxCount = currentCount;
        }
        bst(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        int[] result = new Code501().findMode(root);
        System.out.println(result);
    }
}

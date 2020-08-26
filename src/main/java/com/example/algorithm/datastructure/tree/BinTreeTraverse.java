package com.example.algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: lingjun.jlj
 * @date: 2019-03-13 15:26
 * @description: 二叉树
 */
public class BinTreeTraverse {

    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static List<Node> nodeList = null;

    /**
     * 内部类：节点
     */
    private static class Node {
        Node left;
        Node right;
        int data;

        Node(int newData) {
            left = null;
            right = null;
            data = newData;
        }
    }

    public void createBinTree() {
        nodeList = new LinkedList<>();
        // 将一个数组的值依次转换为Node节点
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {
            nodeList.add(new Node(array[nodeIndex]));
        }
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
            // 左孩子
            nodeList.get(parentIndex).left = nodeList
                    .get(parentIndex * 2 + 1);
            // 右孩子
            nodeList.get(parentIndex).right = nodeList
                    .get(parentIndex * 2 + 2);
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = array.length / 2 - 1;
        // 左孩子
        nodeList.get(lastParentIndex).left = nodeList
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (array.length % 2 == 1) {
            nodeList.get(lastParentIndex).right = nodeList
                    .get(lastParentIndex * 2 + 2);
        }
    }

    /**
     * 先序遍历
     * <p>
     * 先序遍历先从二叉树的根开始，然后到左子树，再到右子树
     *
     * @param node 遍历的节点
     */
    public static void preOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     * <p>
     * 中序遍历先从左子树开始，然后到根，再到右子树
     *
     * @param node 遍历的节点
     */
    public static void inOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        System.out.print(node.data + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     * <p>
     * 后序遍历先从左子树开始，然后到右子树，再到根
     *
     * @param node 遍历的节点
     */
    public static void postOrderTraverse(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 广度优先
     * 对每一层节点依次访问，访问完一层进入下一层，而且每个节点只能访问一次。
     */
    public static List<Integer> BreadthSearch(Node root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<Node> queue = new LinkedList<>();
        //添加尾部节点
        queue.offer(root);
        while (!queue.isEmpty()) {
            //从头部获取节点
            Node tree = queue.poll();
            if (tree.left != null) {
                queue.offer(tree.left);
            }
            if (tree.right != null) {
                queue.offer(tree.right);
            }
            lists.add(tree.data);
        }

        return lists;

    }

    /**
     * 深度优先
     * 是对每一个可能的分支路径深入到不能再深入为止，而且每个节点只能访问一次。
     */
    public static List<Integer> DepthSearch(Node root) {
        List<Integer> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Stack<Node> stack = new Stack<>();
        //添加尾部节点
        stack.push(root);
        while (!stack.isEmpty()) {
            //从头部获取节点
            Node tree = stack.pop();
            if (tree.right != null) {
                stack.push(tree.right);
            }

            if (tree.left != null) {
                stack.push(tree.left);
            }
            lists.add(tree.data);
        }
        return lists;
    }

    public static void main(String[] args) {
        BinTreeTraverse binTree = new BinTreeTraverse();
        binTree.createBinTree();
        // nodeList中第0个索引处的值即为根节点
        Node root = nodeList.get(0);

        System.out.println("先序遍历：");
        preOrderTraverse(root);
        System.out.println();

        System.out.println("中序遍历：");
        inOrderTraverse(root);
        System.out.println();

        System.out.println("后序遍历：");
        postOrderTraverse(root);

        System.out.println();

        System.out.println("广度优先");
        List<Integer> breathList = BreadthSearch(root);
        System.out.println(breathList);

        System.out.println("深度优先");
        List<Integer> depthList = DepthSearch(root);
        System.out.println(depthList);
    }
}

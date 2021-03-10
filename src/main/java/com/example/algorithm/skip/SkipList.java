package com.example.algorithm.skip;

import java.util.Random;

/**
 * @author: lingjun.jlj
 * @date: 2020/9/3 20:34
 * @description: 跳表
 */
public class SkipList {

    private static final int MAX_LEVEL = 16;// 结点的个数
    private int levelCount = 1;//索引的层级数
    private Node head = new Node();
    private Random random = new Random();

    // Node内部类
    public class Node {
        private int data = -1;
        private Node next[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        // 重写toString方法
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{data:");
            builder.append(data);
            builder.append("; leves: ");
            builder.append(maxLevel);
            builder.append(" }");
            return builder.toString();
        }
    }

    /**
     * 查找操作
     *
     * @param value 查找的值
     */
    public Node find(int value) {
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.next[i] != null && p.next[i].data < value) {
                p = p.next[i];
            }
        }

        if (p.next[0] != null && p.next[0].data == value) {
            return p.next[0];    // 找到，则返回原始链表中的结点
        } else {
            return null;
        }
    }

    // 随机函数
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (random.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    // 显示跳表中的结点
    public void display() {
        Node p = head;
        while (p.next[0] != null) {
            System.out.println(p.next[0] + " ");
            p = p.next[0];
        }
        System.out.println();

    }

    public static void main(String[] args) {
        
    }
}

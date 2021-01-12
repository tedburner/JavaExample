package com.example.algorithm.data_structure;

import java.util.Random;

/**
 * @author: lingjun.jlj
 * @date: 2019-02-13 13:59
 * @description: 跳表
 */
public class SkipList<K extends Comparable<K>, V> {

    private static final int MAX_LEVEL = 1 << 4;
    /**
     * 最大层数
     */
    private int maxLevel = 1;
    private Node<K, V> head;

    public SkipList() {
        this.head = new Node<>();
    }

    public SkipList(K key, V value) {
        this.head = new Node<>();
        add(key, value);
    }

    public SkipList(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    static class Node<K extends Comparable<K>, V> {
        K key;
        V value;
        Node<K, V>[] next;

        public Node() {
            this.next = new Node[MAX_LEVEL];
        }

        public Node(K key, V value, int level) {
            if (key == null || value == null) {
                throw new IllegalArgumentException("Key and Value can not be null.");
            }
            this.key = key;
            this.value = value;
            this.next = new Node[level];
        }

        public int compareKey(K k1) {
            return this.key.compareTo(k1);
        }
    }

    /**
     * 通用的查询实现
     *
     * @param key           Key
     * @param previousNodes 前继节点
     * @return 存在返回Node，不存在返回Null
     */
    public Node<K, V> find(K key, Node<K, V>[] previousNodes) {
        Node<K, V> q = null, p = this.head;
        if (null == previousNodes) {
            previousNodes = new Node[this.maxLevel];
        }
        for (int level = this.maxLevel - 1; level >= 0; level--) {
            while (null != (q = p.next[level]) && q.compareKey(key) < 0) {
                p = q;
            }
            previousNodes[level] = p;
        }
        if (null == q || q.compareKey(key) > 0) {
            return null;
        }
        return q;
    }

    /**
     * 通用的查询实现
     *
     * @param key Key
     * @return 存在返回Node，不存在返回Null
     */
    public Node<K, V> find(K key) {
        return this.find(key, null);
    }

    /**
     * 插入元素
     *
     * @param key
     * @param value
     */
    public boolean add(K key, V value) {
        // 生成一个新节点的层.
        int level = randomLevel();
        //待插入节点的每一层的前缀节点
        Node<K, V>[] preNodes = new Node[this.maxLevel];

        // 1. 查询前继节点和目标节点
        Node<K, V> q = find(key, preNodes);

        // key 相等，更新value，直接返回
        if (null != q && q.compareKey(key) == 0) {
            q.value = value;
            return true;
        }
        //2. 新生成一个节点
        Node<K, V> newNode = new Node<>(key, value, level);

        //3.对于没一层，像普通链表一样插入新节点
        int l = level - 1;
        if (level >= this.maxLevel) {
            for (; l >= this.maxLevel; l--) {
                this.head.next[l] = newNode;
            }
            this.maxLevel = level;
        }
        for (; l >= 0; l--) {
            newNode.next[l] = preNodes[l].next[l];
            preNodes[l].next[l] = newNode;
        }
        return true;
    }

    /**
     * 删除指定的key的元素
     *
     * @param key Key
     * @return 对应的值, 不存在返回 null;
     */
    public V delete(K key) {
        Node<K, V>[] previousNodes = new Node[this.maxLevel];
        Node<K, V> kvNode = find(key, previousNodes);

        if (kvNode == null) {
            return null;
        }
        for (int i = previousNodes.length - 1; i >= 0; i--) {
            if (kvNode == previousNodes[i].next[i]) {
                previousNodes[i].next[i] = kvNode.next[i];
                if (this.head.next[i] == null) {
                    this.maxLevel--;
                }
            }
        }
        return kvNode.value;
    }

    /**
     * 打印生成的跳表
     */
    public void printAll() {
        System.out.println("-------------------------");
        for (int level = this.maxLevel - 1; level >= 0; level--) {
            System.out.printf("level: %d\t", level);
            Node<K, V> q = this.head.next[level];
            while (null != q) {
                System.out.print("(" + q.key + "," + q.value + ")\t");
                q = q.next[level];
            }
            System.out.println();
        }
        System.out.println("-------------------------");
    }

    /**
     * 生成一个随机的层数
     *
     * @return
     */
    private int randomLevel() {
        return new Random().nextInt(MAX_LEVEL) + 1;
    }

    public static void main(String[] args) {
        SkipList<Integer, Integer> skipList = new SkipList<>();
        for (int i = 0; i < 100; i++) {
            int randomNum = new Random().nextInt(MAX_LEVEL);
            skipList.add(randomNum, randomNum);
        }
        skipList.printAll();
    }
}

package com.example.algorithm.lru;

import java.util.Hashtable;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/19 20:24
 * @description: LRU: 最近最少使用算法 。 最近最少使用的元素，在接下来一段时间内，被访问的概率也很低。即最近被使用的元素，
 * 在接下来一段时间内，被访问概率较高。
 * <p>
 * 插入一个元素，cache 不满，插到链表头，满，移除cache链尾元素再插入链表头
 * 访问一个元素，从链表头部开始遍历, 访问到之后，将其从原位置删除，重新加入链表头部
 * </p>
 */
public class LRUCache1 {

    class DLinkedNode {
        String key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    private Hashtable<String, DLinkedNode>
            cache = new Hashtable<>();
    private int count;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache1(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        head.pre = null;

        tail = new DLinkedNode();
        tail.post = null;

        head.post = tail;
        tail.pre = head;
    }

    public int get(String key) {

        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1; // should raise exception here.
        }

        // move the accessed node to the head;
        this.moveToHead(node);

        return node.value;
    }


    public void set(String key, int value) {
        DLinkedNode node = cache.get(key);

        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            this.cache.put(key, newNode);
            this.addNode(newNode);

            ++count;

            if (count > capacity) {
                // pop the tail
                DLinkedNode tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        } else {
            // update the value.
            node.value = value;
            this.moveToHead(node);
        }
    }

    /**
     * Always add the new node right after head;
     */
    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    /**
     * Remove an existing node from the linked list.
     */
    private void removeNode(DLinkedNode node) {
        DLinkedNode pre = node.pre;
        DLinkedNode post = node.post;

        pre.post = post;
        post.pre = pre;
    }

    /**
     * Move certain node in between to the head.
     */
    private void moveToHead(DLinkedNode node) {
        this.removeNode(node);
        this.addNode(node);
    }

    // pop the current tail.
    private DLinkedNode popTail() {
        DLinkedNode res = tail.pre;
        this.removeNode(res);
        return res;
    }
}

package com.example.algorithm.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/16 12:32
 * @description: LRU 缓存机制
 * <href=https://leetcode-cn.com/problems/lru-cache/>
 */
public class LRUCache {

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private LinkedList<Node> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
    }

    public int get(int key) {
        Iterator<Node> iterator = list.iterator();
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                // 将当前节点放到队首
                list.remove(node);
                this.put(node.key, node.value);
                return node.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        Iterator<Node> iterator = list.iterator();
        //遍历溢出队列中相同的元素
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                break;
            }
        }
        //如果队列满了，溢出对尾的元素，对尾元素是不使用的
        if (capacity == list.size()) {
            list.removeLast();
        }
        //链表头部添加元素，队首元素是经常使用的元素
        list.addFirst(new Node(key, value));
    }
}

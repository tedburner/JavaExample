package com.example.algorithm.lru;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author: lingjun.jlj
 * @date: 2020/8/19 20:24
 * @description: LRU: 最近最少使用算法 。 最近最少使用的元素，在接下来一段时间内，被访问的概率也很低。即最近被使用的元素，
 * 在接下来一段时间内，被访问概率较高。
 */
public class LRUCache {

    private LinkedList<Node> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new LinkedList<>();
        this.capacity = capacity;
    }

    class Node {
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    /**
     * 访问元素，从头开始遍历，如果遍历到，移除元素并加入对尾
     *
     * @param key
     * @return 如果找不到元素，返回 -1，否则返回对应的value
     */
    public int get(int key) {
        //降序
        Iterator<Node> iterator = cache.iterator();
        int result = -1;
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                result = node.value;
                iterator.remove();
                put(key, result);
                break;
            }
        }
        return result;
    }

    /**
     * 放置元素，如果队列中有相同元素，移除，并放置对尾。如果出现队列满的情况，移除队首元素
     *
     * @param key   元素key
     * @param value 元素值
     */
    public void put(int key, int value) {
        Iterator<Node> iterator = cache.iterator();
        //遍历溢出队列中相同的元素
        while (iterator.hasNext()) {
            Node node = iterator.next();
            if (node.key == key) {
                iterator.remove();
                break;
            }
        }
        //如果队列满了，溢出队首的元素
        if (capacity == cache.size()) {
            cache.removeFirst();
        }
        cache.add(new Node(key, value));
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(10);
        for (int i = 0; i < 10; i++) {
            cache.put(i, i * i);
        }
        for (int i = 10; i >0; i--) {
            cache.put(i, i * i);
        }
        cache.cache.forEach(input -> {
            System.out.println(input.key + " " + input.value);
        });
    }
}

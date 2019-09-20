package com.example.algorithm.datastructure.link;

/**
 * @author: Arthas
 * @date: 2019/9/14 18:11
 * @description: 链表
 */
public class LinkedTest {

    public static void main(String[] args) {
        LinkedTest test = new LinkedTest();
        test.add(1);
        test.add(2);
        test.add(3);

    }

    public class Node {
        int value;
        Node next;

        Node(int x) {
            value = x;
        }
    }

    /**
     * 链表表头
     */
    private Node first;

    private Node last;

    /**
     * 向链表中添加数据
     */
    public void add(int value) {
        Node node = new Node(value);
        final Node linked = last;
        last = node;
        if (linked == null){
            first = node;
        }else {
            linked.next = node;
        }
    }
}

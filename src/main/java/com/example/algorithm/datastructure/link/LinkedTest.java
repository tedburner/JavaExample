package com.example.algorithm.datastructure.link;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/14 18:11
 * @description: 链表
 */
public class LinkedTest {

    public static void main(String[] args) {
        LinkedTest test = new LinkedTest();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(3, 5);

    }

    public class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
        }


    }

    /**
     * 链表表头
     */
    private Node first;

    private Node last;

    private static int count = 0;

    /**
     * 向链表中添加数据
     */
    public void add(int value) {
        Node node = new Node(value);
        final Node linked = last;
        last = node;
        if (linked == null) {
            first = node;
            count++;
        } else {
            linked.next = node;
            count++;
        }
    }

    /**
     * 指定位置添加元素
     *
     * @param index 指定位置
     * @param value 具体值
     */
    public void add(int index, int value) {
        if (index > count) {
            throw new RuntimeException("Index out of");
        }
        Node node = new Node(value);
        if (index == 0) {
            Node oldFirst = first;
            first = node;
            first.next = oldFirst;
        } else {
            Node indexNode = first;
            for (int i = 0; i < index; i++) {
                indexNode = first.next;
            }
            Node next = indexNode.next;
            indexNode.next = node;
            node.next = next;
        }
    }
}

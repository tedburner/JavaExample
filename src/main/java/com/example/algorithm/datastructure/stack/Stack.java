package com.example.algorithm.datastructure.stack;

import java.util.Arrays;

/**
 * @author: lingjun.jlj
 * @date: 2019/9/24 16:09
 * @description:
 */
public class Stack {

    private Object[] elementData;

    private int top;

    /**
     * 栈容量
     */
    private int capacity;

    public Stack(int capacity) {
        this.elementData = new Object[capacity];
        this.capacity = capacity;
        this.top = 0;
    }

    public void push(Object item) {
        if (capacity < (top + 1)) {
            throw new RuntimeException("index out");
        }
        elementData[top++] = item;
    }

    public Object pop() {
        if (top == 0) {
            throw new RuntimeException("Stack is empty!");
        }
        Object object = elementData[--top];
        elementData[top] = null;
        return object;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);
        stack.push(10);
        stack.push(11);
        stack.push(12);
        System.out.println(Arrays.asList(stack.elementData));
    }
}

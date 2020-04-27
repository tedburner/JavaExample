package com.example.designpattern.prototype;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/26 22:55
 * @description:
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

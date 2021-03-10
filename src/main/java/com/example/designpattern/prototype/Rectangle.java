package com.example.designpattern.prototype;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/26 22:53
 * @description:
 */
public class Rectangle extends Shape {

    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}

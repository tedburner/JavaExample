package com.example.designpattern.prototype;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/26 22:54
 * @description:
 */
public class Square extends Shape {


    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

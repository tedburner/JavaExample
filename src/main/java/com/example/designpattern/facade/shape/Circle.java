package com.example.designpattern.facade.shape;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:12
 * @Description:
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("画圆");
    }
}

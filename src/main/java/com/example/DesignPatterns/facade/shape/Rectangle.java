package com.example.DesignPatterns.facade.shape;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:14
 * @Description:
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("画长方形");
    }
}

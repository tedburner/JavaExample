package com.example.designpattern.facade.shape;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:13
 * @Description:
 */
public class Square implements Shape {
    
    @Override
    public void draw() {
        System.out.println("画正方形");
    }
}

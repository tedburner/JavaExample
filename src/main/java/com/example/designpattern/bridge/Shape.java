package com.example.designpattern.bridge;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:02
 * @Description: 形状类
 */
public abstract class Shape {

    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}

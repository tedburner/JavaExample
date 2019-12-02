package com.example.designpattern.bridge;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:00
 * @Description:
 */
public class GreenCircle implements DrawAPI {

    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Draw Circle [ color : green , radius :"
                + radius + ",x: " + x + " , y: " + y + " ]");
    }
}

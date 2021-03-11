package com.example.designpattern.bridge;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:07
 * @Description: 桥接模式
 */
public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }
}

package com.example.designpattern.facade;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:11
 * @Description: 外观模式
 */
public class FacadePatternDemo {

    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }

}

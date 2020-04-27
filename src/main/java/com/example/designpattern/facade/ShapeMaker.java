package com.example.designpattern.facade;

import com.example.designpattern.facade.shape.Circle;
import com.example.designpattern.facade.shape.Rectangle;
import com.example.designpattern.facade.shape.Shape;
import com.example.designpattern.facade.shape.Square;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:14
 * @Description:
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }
    public void drawSquare(){
        square.draw();
    }
}

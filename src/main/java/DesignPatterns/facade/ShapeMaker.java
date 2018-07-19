package DesignPatterns.facade;

import DesignPatterns.facade.shape.Circle;
import DesignPatterns.facade.shape.Rectangle;
import DesignPatterns.facade.shape.Shape;
import DesignPatterns.facade.shape.Square;

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

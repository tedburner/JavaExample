package com.example.designpattern.FlyweightPattern;

import com.example.designpattern.FlyweightPattern.shape.Circle;
import com.example.designpattern.FlyweightPattern.shape.Shape;

import java.util.HashMap;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:26
 * @Description:
 */
public class ShapeFactory {

    private static final HashMap<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}

package com.example.designpattern.order;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/2 15:49
 * @version：1.0
 * @description:
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + " , Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + " , Quantity: " + quantity + " ] sold");
    }
}

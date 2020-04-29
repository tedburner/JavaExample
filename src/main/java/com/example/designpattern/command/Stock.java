package com.example.designpattern.command;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/18 22:55
 * @Description:
 */
public class Stock {


    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity:" + quantity + " ] bought ");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity:" + quantity + " ] sold ");
    }
}

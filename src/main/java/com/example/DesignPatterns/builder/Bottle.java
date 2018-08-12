package com.example.DesignPatterns.builder;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:28
 * @Description: 瓶装
 */
public class Bottle implements Packing {
    @Override
    public String pack() {
        return "Bottle";
    }
}

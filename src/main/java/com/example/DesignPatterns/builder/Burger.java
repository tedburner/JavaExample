package com.example.DesignPatterns.builder;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:29
 * @Description:
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

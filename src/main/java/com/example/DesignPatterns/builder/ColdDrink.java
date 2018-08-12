package com.example.DesignPatterns.builder;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:30
 * @Description:
 */
public abstract class ColdDrink implements Item{

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();

}

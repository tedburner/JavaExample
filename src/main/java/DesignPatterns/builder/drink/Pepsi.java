package DesignPatterns.builder.drink;

import DesignPatterns.builder.ColdDrink;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:33
 * @Description:
 */
public class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}

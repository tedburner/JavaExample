package com.example.DesignPatterns.builder.burgers;

import com.example.DesignPatterns.builder.Burger;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:31
 * @Description: 素食汉堡
 */
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg burgers";
    }
}

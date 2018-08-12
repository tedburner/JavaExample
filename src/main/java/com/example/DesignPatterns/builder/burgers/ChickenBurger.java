package com.example.DesignPatterns.builder.burgers;

import com.example.DesignPatterns.builder.Burger;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:32
 * @Description: 鸡肉汉堡
 */
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}

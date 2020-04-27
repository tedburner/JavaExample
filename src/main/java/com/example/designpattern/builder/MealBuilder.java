package com.example.designpattern.builder;

import com.example.designpattern.builder.burgers.ChickenBurger;
import com.example.designpattern.builder.burgers.VegBurger;
import com.example.designpattern.builder.drink.Coke;
import com.example.designpattern.builder.drink.Pepsi;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:34
 * @Description:
 */
public class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}

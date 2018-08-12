package com.example.DesignPatterns.command;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/18 22:56
 * @Description:
 */
public class SellStock implements Order{
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}

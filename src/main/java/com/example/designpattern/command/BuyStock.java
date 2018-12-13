package com.example.designpattern.command;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/18 22:56
 * @Description:
 */
public class BuyStock implements Order{
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}

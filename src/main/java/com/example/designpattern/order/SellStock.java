package com.example.designpattern.order;

/**
 * @author: lingjun.jlj
 * @date: 2019/7/2 15:51
 * @version：1.0
 * @description:
 */
public class SellStock implements Order {

    private Stock abcStock;

    public SellStock(Stock abcStock) {
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}

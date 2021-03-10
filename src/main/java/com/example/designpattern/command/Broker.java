package com.example.designpattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/18 22:57
 * @Description:
 */
public class Broker {

    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}

package com.example.test.loadbalance;

import lombok.Data;

/**
 * @author: lingjun.jlj
 * @date: 2019/5/9 11:29
 * @description:
 */
@Data
public class Invoker {

    private String ip;
    /**权重*/
    private int weight;

    public Invoker(String ip, int weight) {
        this.ip = ip;
        this.weight = weight;
    }
}

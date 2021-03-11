package com.example.designpattern.builder;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/16 10:27
 * @Description: 包装纸
 */
public class Wrapper implements Packing{

    @Override
    public String pack() {
        return "Wrapper";
    }
}

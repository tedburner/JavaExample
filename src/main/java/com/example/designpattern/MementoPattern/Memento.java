package com.example.designpattern.MementoPattern;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 21:44
 * @Description: 包含了要被恢复的对象的状态
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}

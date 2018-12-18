package com.example.designpattern.Observer;

/**
 * @author lingjun.jlj
 * @data 2018/5/10
 * @Description:
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
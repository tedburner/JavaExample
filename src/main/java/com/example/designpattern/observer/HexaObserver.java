package com.example.designpattern.observer;

/**
 * @author lingjun.jlj
 * @date: 2018/5/10
 * @Description: 字符串输出
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: "
                + Integer.toHexString(subject.getState()).toUpperCase());
    }
}

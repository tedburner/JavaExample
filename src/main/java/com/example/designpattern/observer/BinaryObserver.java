package com.example.designpattern.observer;

/**
 * @author lingjun.jlj
 * @date: 2018/5/10
 * @Description: 二进制输出
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "
                + Integer.toBinaryString(subject.getState()));
    }
}

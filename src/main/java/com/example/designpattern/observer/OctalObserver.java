package com.example.designpattern.observer;

/**
 * @author lingjun.jlj
 * @date: 2018/5/10
 * @Description: 八进制输出
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: "
                + Integer.toOctalString(subject.getState()));
    }
}
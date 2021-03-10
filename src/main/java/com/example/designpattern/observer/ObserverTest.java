package com.example.designpattern.observer;

/**
 * @author lingjun.jlj
 * @date: 2018/5/10
 * @Description: 观察者模式
 * 通过订阅者来通知那些方法需要改变。
 */
public class ObserverTest {

    public static void main(String[] args) {

        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}

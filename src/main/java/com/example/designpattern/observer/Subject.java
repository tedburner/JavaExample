package com.example.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lingjun.jlj
 * @date: 2018/5/10
 * @Description: 订阅者
 */
public class Subject {

    private final List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    /**
     * 存储订阅对象
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 通知所有观察者
     */
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

package com.example.DesignPatterns.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lingjun.jlj
 * @data 2018/5/10
 * @Description: 订阅者
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

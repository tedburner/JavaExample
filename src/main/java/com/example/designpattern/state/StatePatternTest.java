package com.example.designpattern.state;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 11:43
 * @Description: 状态模式：类的行为是基于它的状态改变的。这种类型的设计模式属于行为型模式。
 */
public class StatePatternTest {

    public static void main(String[] args) {
        Context context = new Context();

        StartState start = new StartState();
        start.doAction(context);
        System.out.println(context.getState().toString());

        StopState stop = new StopState();
        stop.doAction(context);
        System.out.println(context.getState().toString());

    }
}

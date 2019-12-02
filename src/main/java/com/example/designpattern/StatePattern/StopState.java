package com.example.designpattern.StatePattern;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 11:47
 * @Description:
 */
public class StopState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}

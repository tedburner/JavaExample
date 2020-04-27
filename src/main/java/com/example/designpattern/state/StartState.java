package com.example.designpattern.state;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 11:47
 * @Description:
 */
public class StartState implements State {

    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        context.setState(this);
    }

    public String toString(){
        return "Start State";
    }
}

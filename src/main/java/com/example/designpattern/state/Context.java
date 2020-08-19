package com.example.designpattern.state;

import lombok.Data;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 11:48
 * @Description:
 */
public class Context {

    private State state;

    public Context() {
        state = null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Context{" +
                "state=" + state +
                '}';
    }
}

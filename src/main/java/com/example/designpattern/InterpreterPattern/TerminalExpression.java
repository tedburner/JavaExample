package com.example.designpattern.InterpreterPattern;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 21:23
 * @Description:
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data){
        this.data = data;
    }

    @Override
    public Boolean interpret(String context) {
        if(context.contains(data)){
            return true;
        }
        return false;
    }
}

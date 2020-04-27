package com.example.designpattern.interpreter;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 21:22
 * @Description:
 */
public interface Expression {

    Boolean interpret(String context);
}

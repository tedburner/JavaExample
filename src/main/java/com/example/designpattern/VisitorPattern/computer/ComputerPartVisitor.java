package com.example.designpattern.VisitorPattern.computer;


/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:47
 * @Description:
 */
public interface ComputerPartVisitor {

    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}

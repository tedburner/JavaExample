package com.example.designpattern.VisitorPattern.computer;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:48
 * @Description:
 */
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
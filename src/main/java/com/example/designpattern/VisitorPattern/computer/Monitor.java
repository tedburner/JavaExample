package com.example.designpattern.VisitorPattern.computer;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:49
 * @Description:
 */
public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

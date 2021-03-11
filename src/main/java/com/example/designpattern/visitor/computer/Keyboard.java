package com.example.designpattern.visitor.computer;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:48
 * @Description: 键盘
 */
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

package com.example.designpattern.visitor.computer;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:49
 * @Description: 显示器
 */
public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

package com.example.designpattern.VisitorPattern.computer;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 15:47
 * @Description:
 */
public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[]{new Mouse(), new Monitor(), new Keyboard()};
    }

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}

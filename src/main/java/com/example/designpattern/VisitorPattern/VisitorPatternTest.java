package com.example.designpattern.VisitorPattern;

import com.example.designpattern.VisitorPattern.computer.Computer;
import com.example.designpattern.VisitorPattern.computer.ComputerPart;
import com.example.designpattern.VisitorPattern.computer.ComputerPartDisplayVisitor;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:43
 * @Description: 访问者模式
 */
public class VisitorPatternTest {

    public static void main(String[] args) {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}

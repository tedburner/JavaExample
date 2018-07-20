package DesignPatterns.VisitorPattern.computer;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:46
 * @Description:
 */
public interface ComputerPart {

    void accept(ComputerPartVisitor computerPartVisitor);
}

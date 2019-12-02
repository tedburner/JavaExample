package com.example.designpattern.ChainPattern;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:58
 * @Description:
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}

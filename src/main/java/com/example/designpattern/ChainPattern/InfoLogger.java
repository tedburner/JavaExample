package com.example.designpattern.ChainPattern;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:53
 * @Description:
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger(int level) {

        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}

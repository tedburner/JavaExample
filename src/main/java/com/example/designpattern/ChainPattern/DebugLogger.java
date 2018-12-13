package com.example.designpattern.ChainPattern;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:59
 * @Description:
 */
public class DebugLogger extends AbstractLogger {

    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}

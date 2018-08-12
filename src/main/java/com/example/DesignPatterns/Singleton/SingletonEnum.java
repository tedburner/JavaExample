package com.example.DesignPatterns.Singleton;

/**
 * @author lingjun.jlj
 * @data 2018/5/18
 * @Description:
 */
public enum SingletonEnum {
    INSTANCE;

    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}

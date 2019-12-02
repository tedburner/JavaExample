package com.example.designpattern.Singleton;

/**
 * @author lingjun.jlj
 * @data 2018/5/18
 * @Description: 枚举单例
 */
public enum SingletonEnum {
    INSTANCE;

    public SingletonEnum getInstance() {
        return INSTANCE;
    }
}

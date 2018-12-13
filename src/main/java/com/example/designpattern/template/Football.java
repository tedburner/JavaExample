package com.example.designpattern.template;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:16
 * @Description:
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}

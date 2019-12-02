package com.example.designpattern.template;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:16
 * @Description:
 */
public class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}

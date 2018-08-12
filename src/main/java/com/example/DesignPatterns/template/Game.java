package com.example.DesignPatterns.template;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:15
 * @Description:
 */
public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }

}

package com.example.DesignPatterns.Decorator;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/11 22:32
 * @Description:
 */
public class Skills implements Hero {

    //持有一个英雄对象接口
    private Hero hero;

    public Skills(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void learnSkills() {
        if (hero != null)
            hero.learnSkills();
    }
}

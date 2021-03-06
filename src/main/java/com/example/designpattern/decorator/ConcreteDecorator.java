package com.example.designpattern.decorator;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/11 22:30
 * @Description: 装饰模式
 */
public class ConcreteDecorator {

    public static void main(String[] args) {
        //选择英雄
        Hero hero = new BlindMonk("盲僧");

        Skills skills = new Skills(hero);
        Skills r = new Skill_R(skills, "猛龙摆尾");
        Skills e = new Skill_E(r, "天雷破/摧筋断骨");
        Skills w = new Skill_W(e, "金钟罩/铁布衫");
        Skills q = new Skill_Q(w, "天音波/回音击");
        //学习技能
        q.learnSkills();
    }
}


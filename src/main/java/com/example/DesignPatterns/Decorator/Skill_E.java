package com.example.DesignPatterns.Decorator;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/11 22:33
 * @Description:
 */
public class Skill_E extends Skills {

    private String skillName;

    public Skill_E(Hero hero,String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能E:"+skillName);
        super.learnSkills();
    }
}

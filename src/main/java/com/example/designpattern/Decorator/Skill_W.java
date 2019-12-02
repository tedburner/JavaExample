package com.example.designpattern.Decorator;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/11 22:34
 * @Description:
 */
public class Skill_W extends Skills{

    private String skillName;

    public Skill_W(Hero hero,String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能W:" + skillName);
        super.learnSkills();
    }
}

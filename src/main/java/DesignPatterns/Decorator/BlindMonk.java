package DesignPatterns.Decorator;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/11 22:31
 * @Description: 盲僧英雄
 */
public class BlindMonk implements Hero{

    private String name;

    public BlindMonk(String name) {
        this.name = name;
    }

    @Override
    public void learnSkills() {
        System.out.println(name + "学习了以上技能！");
    }
}

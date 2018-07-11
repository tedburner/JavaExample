package DesignPatterns.Decorator;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/11 22:35
 * @Description:
 */
public class Skill_R extends Skills {

    private String skillName;

    public Skill_R(Hero hero,String skillName) {
        super(hero);
        this.skillName = skillName;
    }

    @Override
    public void learnSkills() {
        System.out.println("学习了技能R:" +skillName );
        super.learnSkills();
    }
}

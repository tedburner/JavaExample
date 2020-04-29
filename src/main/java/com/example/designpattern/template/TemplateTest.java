package com.example.designpattern.template;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/20 14:14
 * @Description: 模板模式 ： 在类中定义好你需要的，在子类中修改自己需要的方法
 */
public class TemplateTest {

    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}

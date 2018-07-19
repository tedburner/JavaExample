package DesignPatterns.ProxyPattern;

import DesignPatterns.ProxyPattern.image.Image;
import DesignPatterns.ProxyPattern.image.ProxyImage;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:31
 * @Description: 在代理模式（Proxy Pattern）中，一个类代表另一个类的功能。这种类型的设计模式属于结构型模式。
 * 在代理模式中，我们创建具有现有对象的对象，以便向外界提供功能接口。
 */
public class ProxyPatternDemo {

    public static void main(String[] args) {
        Image image = new ProxyImage("MM.PNG");
        image.display();
        image.display();
    }
}

package basejava.basics.extendsTest;

/**
 * Created by jlj on 2017/9/5.
 */
public class Dog extends Animal {

    public Dog() {

    }

    public void cry() {
        super.cry();//调用父类的方法
        System.out.println("狗发出一声。。汪汪。。");
    }
}

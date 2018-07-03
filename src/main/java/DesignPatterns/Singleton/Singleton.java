package DesignPatterns.Singleton;

/**
 * @author lingjun.jlj
 * @create 2017-11-28
 * 单例模式,懒汉模式，双侧检测
 **/
public class Singleton {

    private Singleton() {};

    //volatile修饰符组织了变量访问前后的指令重排，保证指令执行顺序
    private volatile static Singleton instance = null;

    public static Singleton getInstance() {

        if (instance == null) {//双重检测
            synchronized (Singleton.class) {//同步锁
                //if (instance == null) {//双重检测
                    instance = new Singleton();
                //}
            }
        }
        return instance;
    }

}

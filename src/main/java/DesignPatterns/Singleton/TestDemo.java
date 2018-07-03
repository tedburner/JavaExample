package DesignPatterns.Singleton;

/**
 * @author lingjun.jlj
 * @data 2018/5/18
 * @Description: 检查只是加synchronized，并不能保证单例的执行。
 * 1、线程A和线程B同时调用getInstance()方法，
 *    他们同时判断java==null，得出的结果都是为null，所以进入了if代码块了
 * 2、此时线程A得到CPU的控制权-->进入同步代码块-->创建对象-->返回对象
 * 3、线程A完成了以后，此时线程B得到了CPU的控制权。同样是-->进入同步代码块-->创建对象-->返回对象
 */
public class TestDemo {

    public static void main(String[] args) {

        // 线程A
        new Thread(() -> {

            // 创建单例对象
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton);

        }).start();

        // 线程B
        new Thread(() -> {
            // 创建单例对象
            Singleton java3y = Singleton.getInstance();
            System.out.println(java3y);
        }).start();

        // 线程C
        new Thread(() -> {
            // 创建单例对象
            Singleton java3y = Singleton.getInstance();
            System.out.println(java3y);
        }).start();

    }
}

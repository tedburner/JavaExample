package com.example.common;

/**
 * @author: lingjun.jlj
 * @date: 2018-12-14 11:25
 * @description: 多态例子
 */
public class PolymorphicCase {

    public static void main(String[] args) {

        show(new Cat());
        show(new Dog());

        //向上转型
        Animal animal = new Cat();
        animal.eat();//调用的是Cat的 eat
        //当使用多态方式调用方法时，首先检查父类中是否有该方法，
        // 如果没有，则编译错误；如果有，再去调用子类的同名方法
        //animal.work();//编译报错
        //向下转型
        Cat cat = (Cat) animal;
        cat.work();//调用的是Cat的work
    }

    public static void show(Animal animal) {
        animal.eat();
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.work();
        }
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.work();
        }
    }
}

abstract class Animal {
    abstract void eat();
}

class Cat extends Animal {

    @Override
    void eat() {
        System.out.println("猫吃鱼....");
    }

    public void work() {
        System.out.println("猫抓老鼠....");
    }
}

class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("狗吃骨头....");
    }

    public void work() {
        System.out.println("look door....");
    }
}

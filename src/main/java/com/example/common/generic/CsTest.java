package com.example.common.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2021/2/19 11:18
 * @description: CS 表示,如果你的方法只是想往集合写入值,并且集合的类型范围希望是T及其父类,那么泛型可以定义为 ? super T 来表示
 */
public class CsTest {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Apple apple = new Apple();
        apple.addAll(appleList);
    }

    static class Fruit {
        private List<Fruit> fruitList = new ArrayList<>();
//
//        public void addAll(List<Fruit> fruits) {
//            for (Fruit fruit : fruits) {
//                this.fruitList.add(fruit);
//            }
//        }
    }

    static class Apple extends Fruit {
        private Apple apple = new Apple();

        public void addAll(List<? super Apple> apples) {
            apples.add(apple);
        }
    }
}

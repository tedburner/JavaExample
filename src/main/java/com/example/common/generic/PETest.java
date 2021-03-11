package com.example.common.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2021/2/19 11:14
 * @description: PE 表示,如果你的方法只是想从集合获取值,并且希望集合的类型范围是T及其子类,那么泛型可以定义为 ? extends T
 */
public class PETest {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();
        Fruit fruit = new Fruit();
        fruit.addAll(appleList);
    }

    static class Fruit {
        private List<Fruit> fruitList = new ArrayList<>();

        public void addAll(List<? extends Fruit> fruitList) {
            for (Fruit fruit : fruitList) {
                this.fruitList.add(fruit);
            }
        }
    }

    class Apple extends Fruit {

    }

    class Banana extends Fruit {

    }
}

package com.example.designpattern.iterator;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 21:27
 * @Description: 迭代模式
 * 这种模式用于顺序访问集合对象的元素，不需要知道集合对象的底层表示。
 */
public class IteratorPatternTest {

    public static void main(String[] args) {
        NameRepository namesRepository = new NameRepository();

        for (Iterator iterator = namesRepository.getIterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.println("Name : " + name);
        }
    }
}

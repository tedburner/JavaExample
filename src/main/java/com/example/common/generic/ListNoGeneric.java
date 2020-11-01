package com.example.common.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2018-12-11 14:10
 * @description: 泛型和集合
 */
public class ListNoGeneric {

    public static void main(String[] args) {

        //第一阶段：泛型出现之前的集合定义方式
        List a1 = new ArrayList();
        a1.add(new Object());
        a1.add(new Integer(111));
        a1.add(new String("Hello World"));

        for (Object o : a1){
            System.out.println(o);
        }

        //第二段：把a1 引用赋值给a2，注意a2与a1的区别是增加了泛型限制<Object>
        List<Object> a2 = a1;
        a2.add(new Object());
        a2.add(new Integer(222));
        a2.add(new String("hello a2a2"));

        //第三段:把a1引用赋值给a3,注意a3与a1的区别是增加了泛型<Integer>
        List<Integer> a3 = a1;
        a3.add(new Integer(333));
        //下方两行编译出错,不允许增加非 Integer类型进入集合
        //a3.add(new Object());
        //a3.add(new String("hello a3a3"));

        //第四段:把a1引用赋值给a4,a1与a4的区别是增加了通配符
        List<?> a4 = a1;
        a1.remove(0);
        a4.clear();
        //编译出错。不允许增加任何元素
        //a4.add(new Object());


    }
}

package com.example.common.keyword;

import com.example.domain.bean.SimpleDTO;

/**
 * @author: Arthas
 * @date: 2019-01-17 10:11
 * @description: final 修饰类，不可被继承；
 * final修饰方法，不可被重写；
 * final修饰变量，如果普通变量，不能修改，如果是引用变量，引用指针不变，但是内容可以改变
 *
 * 好处：final方法比非final快一些
 * final关键字提高了性能。JVM和Java应用都会缓存final变量。
 * final变量可以安全的在多线程环境下进行共享，而不需要额外的同步开销。
 * 使用final关键字，JVM会对方法、变量及类进行优化。
 */
public class FinalTest {

    public static void main(String[] args) {
        String a = "Arthas2";
        final String b = "Arthas";
        String d = "Arthas";
        String c = b + 2;
        String e = d + 2;
        System.out.println(a == c);
        System.out.println(a == e);

        final SimpleDTO simpleDTO = new SimpleDTO(1, "Arthas");
        //simpleDTO = new SimpleDTO();
        simpleDTO.setName("Jack");
        System.out.println(simpleDTO);
    }
}

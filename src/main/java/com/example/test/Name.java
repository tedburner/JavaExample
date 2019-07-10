package com.example.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @version ：1.0
 * @author: lingjun.jlj
 * @date: 2019/7/10 10:44
 * @description: 重写equals()方法的参数是Object，在这个方法中没有重写equals()，在调用equals()方法的时候，使用的还是HashSet中的equals()方法。
 * 如果参数改为Object，然后强制转化，应该可以
 */
public class Name {

    private String first;
    private String last;


    public Name(String first, String last) {
        if (first == null || last == null) {
            throw new NullPointerException();
        }
        this.first = first;
        this.last = last;
    }

    public boolean equals(Name o) {
        return first.equals(o.first) && last.equals(o.last);
    }

    @Override
    public boolean equals(Object object) {
        Name o = (Name) object;
        return first.equals(o.first) && last.equals(o.last);
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(new Name("Mickey", "Mouse"));
        System.out.println(set.contains(new Name("Mickey", "Mouse")));
    }
}

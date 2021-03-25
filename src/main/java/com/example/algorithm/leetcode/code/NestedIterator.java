package com.example.algorithm.leetcode.code;

import java.util.Iterator;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @date: 2021/3/24 10:56
 * @description: 扁平化嵌套列表迭代器
 */
public class NestedIterator implements Iterator<Integer> {


    public NestedIterator(List<NestedInteger> nestedList) {

    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Integer next() {
        return null;
    }
}

interface NestedInteger {

    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}

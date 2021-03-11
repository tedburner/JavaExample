package com.example.designpattern.filter;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:14
 * @Description: 标准接口
 */
public interface Criteria {

    List<Person> meetCriteria(List<Person> personList);
}

package com.example.designpattern.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:37
 * @Description:
 */
public class CriteriaSingle implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> malePersons = personList.stream()
                .filter(x -> x.getGender().equalsIgnoreCase("SINGLE"))
                .collect(Collectors.toList());
        return malePersons;
    }
}

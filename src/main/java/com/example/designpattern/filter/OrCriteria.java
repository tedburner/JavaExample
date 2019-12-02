package com.example.designpattern.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:40
 * @Description:
 */
public class OrCriteria implements Criteria {
    private Criteria criteria;
    private Criteria otherCriteria;

    public OrCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> personList = criteria.meetCriteria(persons);
        List<Person> otherPersons = criteria.meetCriteria(persons);

        List<Person> peopleList = otherPersons.stream()
                .filter(x -> personList.contains(x))
                .collect(Collectors.toList());

        return peopleList;
    }
}

package DesignPatterns.filter;

import java.util.List;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:38
 * @Description:
 */
public class AndCriteria implements Criteria {

    private Criteria criteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria criteria, Criteria otherCriteria) {
        this.criteria = criteria;
        this.otherCriteria = otherCriteria;
    }

    @Override
    public List<Person> meetCriteria(List<Person> persons) {

        List<Person> personList = criteria.meetCriteria(persons);

        return otherCriteria.meetCriteria(personList);
    }
}

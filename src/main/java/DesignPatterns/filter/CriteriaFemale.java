package DesignPatterns.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:34
 * @Description: 接口实体类
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> malePersons = personList.stream()
                .filter(x -> x.getGender().equalsIgnoreCase("FEMALE"))
                .collect(Collectors.toList());
        return malePersons;
    }
}

package com.example.common.Java8;

import com.example.domain.bean.SimpleDTO;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author lingjun.jlj
 * @date 2017-12-28
 **/
public class toMapTest {

    public static void main(String[] args){
        BeanData beanData = new BeanData();
        List<SimpleDTO> beans = beanData.getBeanData();
        Map<Integer,String> beanMap = beans.stream()
                .collect(Collectors.toMap(x->x.getId(),m->m.getName()));
    }
}

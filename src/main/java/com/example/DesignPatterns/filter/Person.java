package com.example.DesignPatterns.filter;

import lombok.Data;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 11:12
 * @Description:
 */
@Data
public class Person {
    private String name;
    private String gender;
    private String maritalStatus;

    public Person(String name,String gender,String maritalStatus){
        this.name = name;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
    }

}

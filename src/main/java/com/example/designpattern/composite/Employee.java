package com.example.designpattern.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:04
 * @Description:
 */
@Data
public class Employee {
    private String name;
    private String dept;
    private int salary;
    private List<Employee>  employeeList;

    //构造函数
    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        employeeList = new ArrayList<>();
    }

    public void add(Employee e) {
        employeeList.add(e);
    }

    public void remove(Employee e) {
        employeeList.remove(e);
    }


}

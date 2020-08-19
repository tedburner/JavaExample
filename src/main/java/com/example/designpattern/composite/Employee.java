package com.example.designpattern.composite;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/19 15:04
 * @Description:
 */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                ", employeeList=" + employeeList +
                '}';
    }
}

package com.example.programme.service;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/12 23:08
 * @description:
 */
public interface StudentService {

    /**
     * 添加学生数据
     *
     * @param name
     * @param age
     * @param sex
     */
    void save(String name, int age, String sex);
}

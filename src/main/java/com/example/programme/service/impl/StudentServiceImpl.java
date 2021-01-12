package com.example.programme.service.impl;

import com.example.programme.domain.DO.StudentDO;
import com.example.programme.persist.CityMapper;
import com.example.programme.persist.StudentMapper;
import com.example.programme.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/12 23:08
 * @description:
 */
@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void save(String name, int age, String sex) {
        StudentDO student = new StudentDO();
        student.setName(name);
        student.setAge(age);
        student.setSex(sex);
        studentMapper.save(student);
    }
}

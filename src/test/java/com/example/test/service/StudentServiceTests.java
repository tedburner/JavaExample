package com.example.test.service;

import com.example.programme.service.StudentService;
import com.example.test.BaseObserverTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/12 23:12
 * @description:
 */
public class StudentServiceTests extends BaseObserverTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void saveTest() {
        studentService.save("测试", 10, "男");
    }
}

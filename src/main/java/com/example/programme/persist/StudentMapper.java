package com.example.programme.persist;

import com.example.programme.domain.DO.StudentDO;

/**
 * @author: lingjun.jlj
 * @date: 2021/1/12 23:04
 * @description:
 */
public interface StudentMapper {

    /**
     * 添加学生数据
     *
     * @param student
     * @return
     */
    void save(StudentDO student);
}

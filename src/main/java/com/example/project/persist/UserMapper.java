package com.example.project.persist;

import com.example.project.model.DO.UserDO;

import java.util.List;

/**
 * @author lingjun.jlj
 * @create 2017-09-22
 **/

public interface UserMapper {

    Long addUser(UserDO user);

    List<UserDO> selectUser();

}

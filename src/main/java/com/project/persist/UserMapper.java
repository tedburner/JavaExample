package com.project.persist;

import com.project.model.DO.UserDO;

import java.util.List;

/**
 * @author lingjun.jlj
 * @create 2017-09-22
 **/

public interface UserMapper {

    Long addUser(UserDO user);

    List<UserDO> selectUser();

}

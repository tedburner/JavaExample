package com.example.aspect;

import com.example.aspect.annotation.ConsAnnotation;
import com.example.aspect.annotation.Fields;

/**
 * @author: lingjun.jlj
 * @date: 2020/4/2 17:25
 * @description:
 */
@ConsAnnotation(request = {"hello", "world", "annotation!"})
public class User {

    @Fields("中华人民共和国")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

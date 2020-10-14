package com.example.domain.dto;

import lombok.Data;

/**
 * @author: lingjun.jlj
 * @date: 2018/9/18 14:31
 * @description:
 */
@Data
public class UserDTO {

    private Integer id;
    private String name;
    private String password;
    private String email;
}

package com.example.domain.bean;

import lombok.Data;

/**
 * @author lingjun.jlj
 * @date 2017-12-08
 **/
@Data
public class SimpleDTO {
    public Integer id;
    public String name;
    public String content;

    public SimpleDTO() {
    }

    public SimpleDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}

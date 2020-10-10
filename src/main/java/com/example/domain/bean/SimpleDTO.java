package com.example.domain.bean;

import lombok.Data;

/**
 * @author lingjun.jlj
 * @date 2017-12-08
 **/
@Data
public class SimpleDTO {
    private Integer id;
    private String name;
    private String content;

    public SimpleDTO() {
    }

    public SimpleDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleDTO(Integer id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }
}

package com.example.basejava.Java8.bean;

/**
 * @author lingjun.jlj
 * @date 2017-12-08
 **/
public class SimpleDTO {
    public Integer id;
    public String name;

    public SimpleDTO() {
    }

    public SimpleDTO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public String toString() {
        return "SimpleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

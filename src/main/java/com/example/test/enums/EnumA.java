package com.example.test.enums;

import lombok.Getter;

/**
 * @author: Arthas
 * @date: 2019-06-07 23:30
 * @description:
 */
@Getter
public enum  EnumA {

    A1("A1",EnumB.B1, "1001"),

    A2("A2",EnumB.B2,"1002"),;

    private String name;
    private EnumB eb;
    private String code;

    EnumA(String name, EnumB eb, String code) {
        this.name = name;
        this.eb = eb;
        this.code = code;
    }
}

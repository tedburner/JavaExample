package com.example.test.enums;

/**
 * @author: lingjun.jlj
 * @date: 2019-06-07 23:30
 * @description:
 */
public enum EnumB {

    B1("B1", EnumA.A1, "2001"),

    B2("B1", EnumA.A2, "2002"),
    ;

    private String name;
    private EnumA ea;
    private String code;

    EnumB(String name, EnumA ea, String code) {
        this.name = name;
        this.ea = ea;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public EnumA getEa() {
        return ea;
    }

    public String getCode() {
        return code;
    }
}

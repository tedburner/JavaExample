package com.example.enums;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/10 17:08
 * @description:
 */
public enum SimpleEnum {

    A(1,"A"),;

    private Integer code;
    private String text;

    SimpleEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }


    public static SimpleEnum valueOfCode(Integer code) {
        for (SimpleEnum obj : SimpleEnum.values()) {
            if (java.util.Objects.equals(obj.code, code)) {
                return obj;
            }
        }
        return null;
    }

    public static SimpleEnum valueOfText(String text) {
        for (SimpleEnum obj : SimpleEnum.values()) {
            if (java.util.Objects.equals(obj.text, text)) {
                return obj;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

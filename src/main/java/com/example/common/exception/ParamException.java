package com.example.common.exception;

/**
 * @author: lingjun.jlj
 * @date: 2019/6/28 10:13
 * @version：1.0
 * @description: 自定义异常
 */
public class ParamException extends RuntimeException {

    private Integer code;

    public ParamException() {
        super();
    }

    public ParamException(String message) {
        super(message);
    }

    public ParamException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}

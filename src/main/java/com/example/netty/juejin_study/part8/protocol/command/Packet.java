package com.example.netty.juejin_study.part8.protocol.command;

import lombok.Data;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-11 12:01
 * @description:
 */
@Data
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;

    public abstract Byte getCommand();
}

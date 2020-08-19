package com.example.netty.juejin_study.part8.protocol.command;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-11 12:01
 * @description:
 */
public abstract class Packet {

    /**
     * 协议版本
     */
    private Byte version = 1;

    public abstract Byte getCommand();

    public Byte getVersion() {
        return version;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "version=" + version +
                '}';
    }
}

package com.example.netty.juejin_study.part8.protocol.command;

import lombok.Data;

import static com.example.netty.juejin_study.part8.protocol.command.Command.LOGIN_REQUEST;

/**
 * @author: Arthas
 * @date: 2019-01-11 13:53
 * @description:
 */
@Data
public class LoginRequestPacket extends Packet {

    private String userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}

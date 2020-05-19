package com.example.netty.juejin_study.part8.protocol.response;

import com.example.netty.juejin_study.part8.protocol.command.Packet;
import lombok.Data;

import static com.example.netty.juejin_study.part8.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-11 15:15
 * @description:
 */
@Data
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}

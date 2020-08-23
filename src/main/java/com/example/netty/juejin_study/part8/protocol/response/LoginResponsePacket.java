package com.example.netty.juejin_study.part8.protocol.response;

import com.example.netty.juejin_study.part8.protocol.command.Packet;

import static com.example.netty.juejin_study.part8.protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-11 15:15
 * @description:
 */
public class LoginResponsePacket extends Packet {

    private boolean success;

    private String reason;


    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "LoginResponsePacket{" +
                "success=" + success +
                ", reason='" + reason + '\'' +
                "} " + super.toString();
    }
}

package com.example.test.netty;

import com.example.netty.juejin_study.part8.protocol.command.LoginRequestPacket;
import com.example.netty.juejin_study.part8.protocol.command.Packet;
import com.example.netty.juejin_study.part8.protocol.command.PacketCodeC;
import com.example.netty.juejin_study.part8.serialize.Serializer;
import com.example.netty.juejin_study.part8.serialize.impl.JSONSerializer;
import io.netty.buffer.ByteBuf;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

/**
 * @author: Arthas
 * @date: 2019-01-11 14:40
 * @description:
 */
public class PacketCode70CTest {

    @Test
    public void encode() {

        Serializer serializer = new JSONSerializer();
        LoginRequestPacket loginRequestPacket = new LoginRequestPacket();

        loginRequestPacket.setVersion(((byte) 1));
        loginRequestPacket.setUserId(UUID.randomUUID().toString());
        loginRequestPacket.setUsername("keyword man");
        loginRequestPacket.setPassword("password");

        PacketCodeC packetCodeC = new PacketCodeC();
        ByteBuf byteBuf = packetCodeC.encode(loginRequestPacket);
        Packet decodedPacket = packetCodeC.decode(byteBuf);

        Assert.assertArrayEquals(serializer.serialize(loginRequestPacket), serializer.serialize(decodedPacket));

        System.out.println(decodedPacket);

    }
}

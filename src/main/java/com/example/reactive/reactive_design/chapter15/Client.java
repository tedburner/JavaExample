package com.example.reactive.reactive_design.chapter15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import static com.example.reactive.reactive_design.chapter15.Server.SERVER_PORT;

/**
 * @author: Arthas
 * @date: 2019-02-24 22:32
 * @description:
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // get local socket with random port
        try (final DatagramSocket socket = new DatagramSocket()) {

            // send message to server
            final byte[] request = "hello".getBytes();
            final SocketAddress serverAddress = new InetSocketAddress("localhost", SERVER_PORT);
            final DatagramPacket packet1 = new DatagramPacket(request, request.length, serverAddress);
            socket.send(packet1);

            // receive one packet
            final byte[] buffer = new byte[1500];
            final DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet2);

            final SocketAddress sender = packet2.getSocketAddress();
            System.out.println("client: received " + new String(packet2.getData()));
            System.out.println("client: sender was " + sender);
        }
    }
}

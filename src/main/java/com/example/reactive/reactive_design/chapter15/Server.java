package com.example.reactive.reactive_design.chapter15;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

/**
 * @author: Arthas
 * @date: 2019-02-24 22:27
 * @description:
 */
public class Server {

    static final int SERVER_PORT = 8888;

    public static void main(String[] args) throws IOException {
        // bind a socket for receiving packets
        try (final DatagramSocket socket = new DatagramSocket(SERVER_PORT)) {

            // receive one packet
            final byte[] buffer = new byte[1500];
            final DatagramPacket packet1 = new DatagramPacket(buffer, buffer.length);
            socket.receive(packet1);

            final SocketAddress sender = packet1.getSocketAddress();
            System.out.println("server: received " + new String(packet1.getData()));
            System.out.println("server: sender was " + sender);

            // send response back
            final byte[] response = "got it!".getBytes();
            final DatagramPacket packet2 = new DatagramPacket(response, response.length, sender);
            socket.send(packet2);
        }
    }
}

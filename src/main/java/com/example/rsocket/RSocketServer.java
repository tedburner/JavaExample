package com.example.rsocket;

import io.rsocket.AbstractRSocket;
import io.rsocket.ConnectionSetupPayload;
import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.RSocketFactory;
import io.rsocket.SocketAcceptor;
import io.rsocket.frame.decoder.PayloadDecoder;
import io.rsocket.transport.netty.server.TcpServerTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * @author: lingjun.jlj
 * @date: 2019/10/8 11:48
 * @description:
 */
public class RSocketServer {

    public static void main(String[] args) {
        RSocketFactory.receive()
                .frameDecoder(PayloadDecoder.ZERO_COPY)
                .acceptor(new SocketAcceptorImpl())
                .transport(TcpServerTransport.create(7878))
                .start()
                .block()
                .onClose()
                .block();
    }

    private static class SocketAcceptorImpl implements SocketAcceptor {
        @Override
        public Mono<RSocket> accept(ConnectionSetupPayload setupPayload, RSocket reactiveSocket) {
            return Mono.just(
                    new AbstractRSocket() {
                        @Override
                        public Flux<Payload> requestStream(Payload payload) {
                            return Flux.interval(Duration.ofMillis(100))
                                    .map(aLong -> DefaultPayload.create("Interval: " + aLong));
                        }
                    });
        }
    }
}
package com.example.netty.netty_in_action.chapter10;

import io.netty.channel.CombinedChannelDuplexHandler;

/**
 * @author: Arthas
 * @date: 2019-05-19 17:03
 * @description: 编解码器
 */
public class CombinedByteCharCodec extends CombinedChannelDuplexHandler<ByteToCharDecoder, CharToByteEncoder> {
    public CombinedByteCharCodec() {
        super(new ByteToCharDecoder(), new CharToByteEncoder());
    }
}

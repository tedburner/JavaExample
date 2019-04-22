package io.netty.channel;


import io.netty.util.concurrent.EventExecutor;

/**
 * @author: Arthas
 * @date: 2019-04-22 23:02
 * @description:
 */
public class DummyChannelHandlerContext extends AbstractChannelHandlerContext {

    public static ChannelHandlerContext DUMMY_INSTANCE = new DummyChannelHandlerContext(
            null,
            null,
            null,
            true,
            true
    );

    public DummyChannelHandlerContext(DefaultChannelPipeline pipeline,
                                      EventExecutor executor,
                                      String name, boolean inbound, boolean outbound) {
        super(pipeline, executor, name, inbound, outbound);
    }

    @Override
    public ChannelHandler handler() {
        return null;
    }
}

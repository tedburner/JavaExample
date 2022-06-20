package io.netty.channel;


import io.netty.util.concurrent.EventExecutor;

/**
 * @author lingjun.jlj
 * @date 2019-04-22 23:02
 */
@Deprecated
public class DummyChannelHandlerContext extends AbstractChannelHandlerContext {

    DummyChannelHandlerContext(DefaultChannelPipeline pipeline, EventExecutor executor, String name, Class<? extends ChannelHandler> handlerClass) {
        super(pipeline, executor, name, handlerClass);
    }

//    public static ChannelHandlerContext DUMMY_INSTANCE = new DummyChannelHandlerContext(
//            null,
//            null,
//            null,
//    );

//    public DummyChannelHandlerContext(DefaultChannelPipeline pipeline,
//                                      EventExecutor executor,
//                                      String name,
//                                       ChannelPipeline pipeline) {
//        super(pipeline, executor, name, pipeline);
//    }

    @Override
    public ChannelHandler handler() {
        return null;
    }
}

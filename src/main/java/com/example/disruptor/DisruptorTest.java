package com.example.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;

/**
 * @author: Lucifer
 * @date: 2018-12-18 16:53
 * @description: Disruptor 高性能队列
 * blog: https://tech.meituan.com/disruptor.html
 */
public class DisruptorTest {

    public static void main(String[] args) throws InterruptedException {
        //队列中的元素
        class Element {
            private int value;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        //生产者的线程工厂
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "simple thread");
            }
        };
        //RingBuffer 生成工厂，初始化 RingBuffer的时候使用
        EventFactory<Element> factory = new EventFactory<Element>() {
            @Override
            public Element newInstance() {
                return new Element();
            }
        };

        //处理 Event 的handler
        EventHandler<Element> handler = new EventHandler<Element>() {
            @Override
            public void onEvent(Element element, long l, boolean b) throws Exception {
                System.out.println("Element: " + element.getValue());
            }
        };

        //阻塞策略
        BlockingWaitStrategy strategy = new BlockingWaitStrategy();

        //指定 RingBuffer
        int bufferSize = 16;

        //创建 disruptor,采用单线程模式
        Disruptor<Element> disruptor = new Disruptor(factory, bufferSize, threadFactory, ProducerType.SINGLE, strategy);

        //设置EventHandler
        disruptor.handleEventsWith(handler);

        //启动disruptor
        disruptor.start();

        RingBuffer<Element> ringBuffer = disruptor.getRingBuffer();

        for (int i = 0; true; i++) {
            //获取下一个可用位置下标
            long sequence = ringBuffer.next();
            try {
                //返回可用位置的元素
                Element event = ringBuffer.get(sequence);
                //设置该位置元素的值
                event.setValue(i);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ringBuffer.publish(sequence);
            }
            Thread.sleep(10L);
        }
    }
}

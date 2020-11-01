package com.example.disruptor;

import com.lmax.disruptor.*;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
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

        //阻塞策略，加锁，使用场景：CPU资源紧缺，吞吐量和延迟并不重要
        BlockingWaitStrategy strategy = new BlockingWaitStrategy();
        //自旋锁,通过不断重试，减少切换线程导致的系统调用，而降低延迟。推荐在线程绑定到固定的CPU的场景下使用
        //BusySpinWaitStrategy strategy =  new BusySpinWaitStrategy();
        //自旋 + yield + 自定义策略，CPU资源紧缺，吞吐量和延迟并不重要的场景
        //PhasedBackoffWaitStrategy strategy = new PhasedBackoffWaitStrategy(1L, 1L, TimeUnit.SECONDS, new WaitStrategy());
        //自旋 + yield + sleep,性能和CPU资源之间有很好的折中。延迟不均匀
        //SleepingWaitStrategy strategy =  new SleepingWaitStrategy();
        //加锁，有超时限制	CPU资源紧缺，吞吐量和延迟并不重要的场景
        //TimeoutBlockingWaitStrategy strategy = new TimeoutBlockingWaitStrategy(1L, TimeUnit.SECONDS);
        //自旋 + yield + 自旋,性能和CPU资源之间有很好的折中。延迟比较均匀
        //YieldingWaitStrategy strategy = new YieldingWaitStrategy();

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

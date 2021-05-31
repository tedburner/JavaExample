package com.example.algorithm.limit;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: lingjun.jlj
 * @date: 2021/5/15 16:53
 * @description: 令桶牌算法
 */
public class TokenBucket {

    // 默认桶大小个数，即最大瞬间流量64M
    private static final int DEFAULT_BUCKET_SIZE = 1024 * 1024 * 64;
    // 一个桶的字节为1字节
    private int EVERY_TOKEN_SIZE = 1;
    // 瞬间最大流量
    private int MAX_FLOW_RATE;
    // 平均流量
    private int AVG_FLOW_RATE;
    // 默认缓存桶数量，最大流量峰值就是 默认峰值 64M
    private Queue<Byte> TOKEN_QUEUE = new ArrayBlockingQueue<>(DEFAULT_BUCKET_SIZE);

    private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    private volatile boolean state = false;

    private final static ReentrantLock lock = new ReentrantLock(true);

    private static final byte A_CHAR = 'a';

    public TokenBucket() {
    }

    public TokenBucket(int MAX_FLOW_RATE, int AVG_FLOW_RATE) {
        this.MAX_FLOW_RATE = MAX_FLOW_RATE;
        this.AVG_FLOW_RATE = AVG_FLOW_RATE;
    }

    public TokenBucket(int EVERY_TOKEN_SIZE, int MAX_FLOW_RATE, int AVG_FLOW_RATE) {
        this.EVERY_TOKEN_SIZE = EVERY_TOKEN_SIZE;
        this.MAX_FLOW_RATE = MAX_FLOW_RATE;
        this.AVG_FLOW_RATE = AVG_FLOW_RATE;
    }

    /**
     * 添加桶牌
     *
     * @param tokenNum 桶牌数量
     */
    public void addTokens(Integer tokenNum) {
        // 若是桶已经满了，就不再添加新的令牌
        for (int i = 0; i < tokenNum; i++) {
            TOKEN_QUEUE.offer(A_CHAR);
        }
    }

    /**
     * 构建桶牌
     *
     * @return
     */
    public TokenBucket build() {
        start();
        return this;
    }

    /**
     * 获取足够的令牌个数
     *
     * @param dataSize 数据大小
     * @return
     */
    public boolean getTokens(byte[] dataSize) {
        // 传输内容大小对应的桶个数
        int needTokenNum = dataSize.length / EVERY_TOKEN_SIZE + 1;

        lock.lock();
        try {
            // 是否存在足够的桶数量
            boolean result = needTokenNum <= TOKEN_QUEUE.size();
            if (!result) {
                return false;
            }

            int tokenCount = 0;
            for (int i = 0; i < needTokenNum; i++) {
                Byte poll = TOKEN_QUEUE.poll();
                if (poll != null) {
                    tokenCount++;
                }
            }

            return tokenCount == needTokenNum;
        } finally {
            lock.unlock();
        }
    }

    public void start() {
        // 初始化桶队列大小
        if (MAX_FLOW_RATE != 0) {
            TOKEN_QUEUE = new ArrayBlockingQueue<>(MAX_FLOW_RATE);
        }

        // 初始化令牌生产者，每分钟产生N块令牌
        TokenProducer tokenProducer = new TokenProducer(AVG_FLOW_RATE, this);
        scheduledExecutorService.scheduleAtFixedRate(tokenProducer, 0, 1,
                TimeUnit.SECONDS);
        state = true;

    }

    public void stop() {
        state = false;
        scheduledExecutorService.shutdown();
    }

    public boolean isStarted() {
        return state;
    }

    /**
     * 生成桶牌
     */
    class TokenProducer implements Runnable {

        private int avgFlowRate;
        private TokenBucket tokenBucket;

        public TokenProducer(int avgFlowRate, TokenBucket tokenBucket) {
            this.avgFlowRate = avgFlowRate;
            this.tokenBucket = tokenBucket;
        }

        @Override
        public void run() {
            tokenBucket.addTokens(avgFlowRate);
        }
    }

    public static TokenBucket newBuilder() {
        return new TokenBucket();
    }

    public TokenBucket everyTokenSize(int everyTokenSize) {
        this.EVERY_TOKEN_SIZE = everyTokenSize;
        return this;
    }

    public TokenBucket maxFlowRate(int maxFlowRate) {
        this.MAX_FLOW_RATE = maxFlowRate;
        return this;
    }

    public TokenBucket avgFlowRate(int avgFlowRate) {
        this.AVG_FLOW_RATE = avgFlowRate;
        return this;
    }

    private String stringCopy(String data, int copyNum) {
        StringBuilder builder = new StringBuilder(data.length() * copyNum);
        for (int i = 0; i < copyNum; i++) {
            builder.append(data);
        }
        return builder.toString();
    }

    private static void arrayTest() {
        ArrayBlockingQueue<Integer> tokenQueue = new ArrayBlockingQueue<>(
                10);
        tokenQueue.offer(1);
        tokenQueue.offer(1);
        tokenQueue.offer(1);
        System.out.println(tokenQueue.size());
        System.out.println(tokenQueue.remainingCapacity());
    }

    private static void tokenTest() throws InterruptedException, IOException {
        TokenBucket tokenBucket = TokenBucket.newBuilder()
                .avgFlowRate(512)
                .maxFlowRate(1024)
                .build();

        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("D:/ds_test")));
        // 四个字节
        String data = "xxxx";
        for (int i = 1; i <= 1000; i++) {
            Random random = new Random();
            int i1 = random.nextInt(100);
            boolean tokens = tokenBucket.getTokens(tokenBucket.stringCopy(data,
                    i1).getBytes());
            TimeUnit.MILLISECONDS.sleep(100);
            if (tokens) {
                bufferedWriter.write("token pass --- index:" + i1);
                System.out.println("token pass --- index:" + i1);
            } else {
                bufferedWriter.write("token rejuect --- index" + i1);
                System.out.println("token rejuect --- index" + i1);
            }

            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

        bufferedWriter.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        tokenTest();
    }
}

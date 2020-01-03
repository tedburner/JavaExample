package com.example.common.concurrent.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author lingjun.jlj
 * @create 2017-11-17
 **/
public class ThreadPoolTest {

    /**
     * 线程池维护线程的最少数量
     */
    private int corePoolSize = 16;

    /**
     * 线程池维护线程的最大数量
     */
    private int maximumPoolSize = 64;

    /**
     * 线程池维护线程所允许的空闲时间
     */
    private int keepAliveTime = 60;

    /**
     * 线程池所使用的缓冲队列的最大数量,用于创建有界的缓冲队列
     */
    private int queueSize = 256;

    /**
     * 线程池所使用的缓冲队列
     */
    private BlockingQueue<Runnable> workQueue;

    /**
     * 线程池对拒绝任务的处理策略
     */
    private RejectedExecutionHandler handler;

    private ThreadFactory threadFactory;

    private ThreadPoolExecutor threadPoolExecutor;

    public void initialize() {
        workQueue = new ArrayBlockingQueue(queueSize);
        //threadFactory = new NamedThreadFactory("Parallel-Processor", null, true);
        handler = new ThreadPoolExecutor.CallerRunsPolicy();
        threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue, threadFactory, handler);
        //interfaceTest = MoreExecutors.listeningDecorator(threadPoolExecutor);
    }

    /**
     * 初始化一个指定线程数的线程池，其中corePoolSize == maximumPoolSize，
     * 使用LinkedBlockingQuene作为阻塞队列，不过当线程池没有可执行任务时，也不会释放线程。
     */
    private static Executor executor = Executors.newFixedThreadPool(10);

    /**
     * 1、初始化一个可以缓存线程的线程池，默认缓存60s，线程池的线程数可达到Integer.MAX_VALUE，
     * 即2147483647，内部使用SynchronousQueue作为阻塞队列；
     * 2、和newFixedThreadPool创建的线程池不同，newCachedThreadPool在没有任务执行时，
     * 当线程的空闲时间超过keepAliveTime，会自动释放线程资源，当提交新任务时，如果没有空闲线程，
     * 则创建新线程执行任务，会导致一定的系统开销；
     */
    private static Executor cachePool = Executors.newCachedThreadPool();

    /**
     * 初始化的线程池中只有一个线程，如果该线程异常结束，会重新创建一个新的线程继续执行任务，
     * 唯一的线程可以保证所提交任务的顺序执行，内部使用LinkedBlockingQueue作为阻塞队列。
     */
    private static Executor singlePool = Executors.newSingleThreadExecutor();

    /**
     * 初始化的线程池可以在指定的时间内周期性的执行所提交的任务，
     * 在实际的业务场景中可以使用该线程池定期的同步数据。
     * 除了newScheduledThreadPool的内部实现特殊一点之外，
     * 其它几个线程池都是基于ThreadPoolExecutor类实现的。
     */
    private static Executor schedulePool = Executors.newScheduledThreadPool(10);

    /**
     * Java8之后添加的构建线程池方法。
     * 获取当前可用的线程数量进行创建作为并行级别
     * 底层使用ForkJoinPool来实现
     * <p>
     * 创建一个拥有多个任务队列的线程池，可以减少连接数，创建当前可用cpu数量的线程来并行执行，适用于大耗时的操作，可以并行来执行，
     */
    private static Executor workStealingPool = Executors.newWorkStealingPool();

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            executor.execute(new Task());
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

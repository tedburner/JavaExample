package basejava.basics.concurrent.queue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/29 15:25
 * @description:
 */
public class PriorityBlockingQueueTest {

    public static void main(String[] args) {
        PriorityBlockingQueue queue = new PriorityBlockingQueue();
        queue.put(1);
        queue.add(2);
        queue.offer(3);
        queue.poll();
    }
}

package basejava.basics.concurrent.queue;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author: lingjun.jlj
 * @date: 2018/7/30 09:42
 * @description:
 */
public class DelayQueueTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayTask> queue = new DelayQueue<DelayTask>();

        for (int i = 1; i < 11; i++) {
            DelayTask m = new DelayTask("DelayTask" + i, i * 1000L, TimeUnit.MILLISECONDS);
            queue.add(m);
        }

        while (!queue.isEmpty()) {
            DelayTask message = queue.take();//此处会阻塞
            //执行广告上下架操作
            System.out.println(message);
        }
    }

}

class DelayTask implements Delayed {
    public String name;
    public Long delayTime;
    public TimeUnit delayTimeUnit;
    public Long executeTime;//ms

    DelayTask(String name, long delayTime, TimeUnit delayTimeUnit) {
        this.name = name;
        this.delayTime = delayTime;
        this.delayTimeUnit = delayTimeUnit;
        this.executeTime = System.currentTimeMillis() + delayTimeUnit.toMillis(delayTime);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(executeTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.getDelay(TimeUnit.MILLISECONDS) > o.getDelay(TimeUnit.MILLISECONDS)) {
            return 1;
        } else if (this.getDelay(TimeUnit.MILLISECONDS) < o.getDelay(TimeUnit.MILLISECONDS)) {
            return -1;
        }
        return 0;
    }

}
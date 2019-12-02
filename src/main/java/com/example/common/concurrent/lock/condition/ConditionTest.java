package com.example.common.concurrent.lock.condition;

/**
 * @author: lingjun.jlj
 * @date: 2018/10/17 10:45
 * @description:
 */
public class ConditionTest {

    /**
     * 写人物
     */
    static class WriteTask implements Runnable {
        private ConditionDemo condition;

        public WriteTask(ConditionDemo condition) {
            this.condition = condition;
        }

        @Override
        public void run() {
            for (int k = 1; k <= 20; k++) {
                condition.put();
            }
        }
    }

    /**
     * 读任务
     */
    static class ReadTask implements Runnable {
        private ConditionDemo condition;

        public ReadTask(ConditionDemo conditionDemo) {
            this.condition = conditionDemo;
        }

        @Override
        public void run() {
            for (int k = 1; k <= 20; k++) {
                condition.take();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo conditionDemo = new ConditionDemo();
        new Thread(new WriteTask(conditionDemo)).start();
        new Thread(new ReadTask(conditionDemo)).start();

        //使主线程休眠
        Thread.sleep(15000);

    }
}

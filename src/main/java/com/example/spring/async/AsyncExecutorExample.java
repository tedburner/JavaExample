package com.example.spring.async;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author: lingjun.jlj
 * @date: 2020/11/1 16:54
 * @description:
 */
public class AsyncExecutorExample {

    private class MessagePrintTask implements Runnable {

        private String message;

        public MessagePrintTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " " + message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private TaskExecutor taskExecutor;

    public TaskExecutor getTaskExecutor() {
        return taskExecutor;
    }

    public void setTaskExecutor(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void printMessage() {
        for (int i = 0; i <= 10; i++) {
            taskExecutor.execute(new MessagePrintTask("Message" + i));
        }
    }

    public void shutdown() {
        if (taskExecutor instanceof ThreadPoolTaskExecutor) {
            ((ThreadPoolTaskExecutor) taskExecutor).shutdown();
        }
    }

    public static void main(String[] args) {
        //创建容器上下文
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});

        //获取 AsyncExecutorExample 实例并调用打印方法
        System.out.println(Thread.currentThread().getName() + " begin");
        AsyncExecutorExample asyncExecutorExample = applicationContext.getBean(AsyncExecutorExample.class);
        asyncExecutorExample.printMessage();
        //关闭线程
        asyncExecutorExample.shutdown();
        System.out.println(Thread.currentThread().getName() + " end");
    }
}

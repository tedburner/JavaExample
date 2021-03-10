package com.example.common.concurrent.thread.group;

/**
 * @author: lingjun.jlj
 * @date: 2020/5/26 16:24
 * @description:
 */
public class ThreadGroupCase {

    public static void main(String[] args) {
        //获取当前线程的group
        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
        //定义一个新的 group，在没有指定父group，默认当前线程所在的group为父group
        ThreadGroup group1 = new ThreadGroup("Group1");

        //程序输出 true
        System.out.println(group1.getParent() == currentGroup);
        //定义group2，指定group1为其父group
        ThreadGroup group2 = new ThreadGroup(group1, "Group2");
        //程序输出 true
        System.out.println(group2.getParent() == group1);
    }
}

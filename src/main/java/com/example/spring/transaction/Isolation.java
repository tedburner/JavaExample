package com.example.spring.transaction;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/5 19:39
 * @Description: Isolation是事务自带事务隔离级别, 隔离级别是指若干个并发的事务之间的隔离程度.
 * 官方文档解释：https://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/transaction/annotation/Isolation.html
 */
public enum Isolation {

    /**
     * 使用基础数据存储的默认隔离级别。
     */
    DEFAULT,

    /**
     * 一个常量，表示防止脏读; 可以发生不可重复的读取和幻像读取。
     * 该隔离级别表示一个事务只能读取另一个事务已经提交的数据。
     */
    READ_COMMITTED,

    /**
     * 一个常量，表示可以发生脏读，不可重复读和幻像读。
     * 该隔离级别表示一个事务可以读取另一个事务修改但还没有提交的数据。
     */
    READ_UNCOMMITTED,

    /**
     *一个常量，表示防止脏读和不可重复读; 可以发生幻像读取。
     * 该隔离级别表示一个事务在整个过程中可以多次重复执行某个查询，并且每次返回的记录都相同。
     * */
    REPEATABLE_READ,

    /**
     *一个常量，表示禁止脏读，不可重复读和幻像读。
     * 所有的事务依次逐个执行，这样事务之间就完全不可能产生干扰，也就是说，该级别可以防止脏读、不可重复读以及幻读。
     * */
    SERIALIZABLE,;
}

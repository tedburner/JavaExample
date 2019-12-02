package com.example.spring.transaction;

/**
 * @author: lingjun.jlj
 * @Date: 2018/7/5 19:34
 * @Description: 事务的传播特性
 *
 * https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html
 */
public enum Propagation {
    /**
     * 支持当前事务，如果不存在则抛出异常。
     */
    MANDATORY(),
    /**
     * 如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；
     * 如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
     */
    NESTED,
    /**
     * 如果事务存在，则以非事务方式执行，抛出异常。
     */
    NEVER,
    /**
     * 以非事务方式执行，暂停当前事务（如果存在）。
     */
    NOT_SUPPORTED,
    /**
     * 支持当前事务，如果不存在则创建新事务。
     */
    REQUIRED,
    /**
     * 创建一个新事务，并暂停当前事务（如果存在）。
     */
    REQUIRES_NEW,
    /**
     * 支持当前事务，如果不存在则以非事务方式执行。
     */
    SUPPORTS,;

}

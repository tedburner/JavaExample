package com.example.reactive.reactive_design.chapter03.future;

/**
 * @author: lingjun.jlj
 * @date: 2019-01-10 21:46
 * @description:
 */
public interface DBRetriever {

    Customer getCustomer(long customerId);
}

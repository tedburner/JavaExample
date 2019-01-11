package com.example.reactive.chapter03.future;

/**
 * @author: Arthas
 * @date: 2019-01-10 21:45
 * @description:
 */
public interface CacheRetriever {
    Customer getCustomer(long customerId);
}

package com.example.reactive.chapter03.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author: Arthas
 * @date: 2019-01-10 21:39
 * @description: 并行非阻塞调用
 */
public class ParallelRetrievalExample {

    private final CacheRetriever cacheRetriever;
    private final DBRetriever dbRetriever;

    ParallelRetrievalExample(CacheRetriever cacheRetriever, DBRetriever dbRetriever) {
        this.cacheRetriever = cacheRetriever;
        this.dbRetriever = dbRetriever;
    }

    public Object retrieveCustomer(final long id) {
        final CompletableFuture<Object> cacheFuture =
                CompletableFuture.supplyAsync(() -> cacheRetriever.getCustomer(id));
        final CompletableFuture<Object> dbFuture =
                CompletableFuture.supplyAsync(() -> dbRetriever.getCustomer(id));

        return CompletableFuture.anyOf(cacheFuture, dbFuture);
    }


    public static void main(String[] args) {

    }
}

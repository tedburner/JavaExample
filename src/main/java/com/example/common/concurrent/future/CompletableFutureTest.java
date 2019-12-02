package com.example.common.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: Arthas
 * @date: 2019-03-22 13:45
 * @description: CompletableFuture 测试类
 */
public class CompletableFutureTest {

    public static Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture
                = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.complete("Hello");
            return null;
        });

        return completableFuture;
    }

    /**
     * 假设我们没有找到结果并决定完全取消异步执行任务
     * 当Future.get()阻塞结果的时候，会取消执行任务，并抛出CancellationException异常
     */
    public static Future<String> calculateAsyncWithCancellation() {

        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            Thread.sleep(500);
            completableFuture.cancel(false);
            return null;
        });

        return completableFuture;
    }

    public static void main(String[] args) {
        try {
            Future<String> future = calculateAsync();
            System.out.println(future.get());
//
//            Future<String> cancel = calculateAsyncWithCancellation();
//            System.out.println(cancel.get());

            //thenRun()使用,任务A执行完执行任务B，但是任务B不依赖任务A
            CompletableFuture<Void> thenRunFuture = CompletableFuture
                    .supplyAsync(() -> "Hello")
                    .thenRun(() -> System.out.println("Computation finished."));

            thenRunFuture.get();

            /**thenAccept()使用 在两个任务任务A，
             * 任务B中，如果你不需要在Future中有返回值，
             * 则可以用 thenAccept方法接收将计算结果传递给它。最后的future.get（）调用返回Void类型的实例。
             */
            CompletableFuture<Void> accept = CompletableFuture
                    .supplyAsync(() -> "Hello ")
                    .thenAccept(s -> System.out.println(s + " thenAccept!"));
            System.out.println(accept.get());

            /**
             * thenApply()使用
             * */
            CompletableFuture<String> apply = CompletableFuture
                    .supplyAsync(() -> "Hello")
                    .thenApply(s -> s + " thenApply");

            System.out.println(apply.get());

            /**
             * thenCompose()使用
             * */
            CompletableFuture compose = CompletableFuture
                    .supplyAsync(() -> "Hello")
                    .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " thenCompose"));
            System.out.println(compose.get());

            /**thenCombine()
             * 取两个任务的结果
             * */
            CompletableFuture combine = CompletableFuture
                    .supplyAsync(() -> 6)
                    .thenCombine(CompletableFuture.supplyAsync(
                            () -> 3), (s1, s2) -> s1 - s2);
            System.out.println(combine.get());

            /**
             * 当你想要使用两个Future结果时，但不需要将任何结果值进行返回
             * */
            CompletableFuture thenAcceptBoth = CompletableFuture.supplyAsync(() -> "Hello")
                    .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
                            (s1, s2) -> System.out.println(s1 + s2));
            System.out.println(thenAcceptBoth.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

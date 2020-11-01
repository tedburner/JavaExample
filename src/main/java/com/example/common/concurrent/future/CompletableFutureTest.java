package com.example.common.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author: lingjun.jlj
 * @date: 2019-03-22 13:45
 * @description: CompletableFuture 是一个可以通过编程方式显示地设置计算结果和状态以便让任务结束的Future，并且其可以作为一个
 * CompletionStage，当它计算完成时可以触发一个函数或者行为；当多个线程企图调用同一个 CompletableFuture 的 complete、cancel 方式
 * 时只有一个线程会成功。
 * <p>
 * runAsync:基于runAsync 实现无返回值的异步计算
 * <p>
 * supplyAsync:基于supplyAsync 实现有返回值的异步计算
 * <p>
 * thenRun:基于thenRun实现异步任务A，执行完毕后，激活异步任务B执行，这种激活的异步任务B是拿不到任务A的执行结果的。
 * <p>
 * 可以使用 thenRunAsync(Runnable action, Executor executor)来指定设置的回调事件使用自定义线程池来执行
 * <p>
 * thenAccept:基于thenAccept实现任务A，执行完毕后，激活异步任务B执行，在这种激活方式下，异步任务B是可以拿到任务A的执行结果的
 * <p>
 * thenApply:基于thenApply实现异步任务A，执行完毕后，激活异步任务B执行。在这种激活方式下，异步任务B是可以拿到任务A的执行结果，并且
 * 可以获取到异步任务B的执行结果
 * <p>
 * whenComplete:基于whenComplete设置回调函数，当异步任务执行完毕后，进行回调，不会阻塞调用线程
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

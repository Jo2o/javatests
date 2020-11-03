package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Sample03 {

    public static void process(CompletableFuture<Integer> future) {
        future.thenApply(data -> data * 2)               // formed a pipeline
                .thenApply(data -> data * data)
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        process(future);
        future.complete(2);
    }

}

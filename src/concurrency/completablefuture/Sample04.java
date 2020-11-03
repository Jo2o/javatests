package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Sample04 {

    private static int handle(Throwable throwable) {
        System.out.println("Error: " + throwable);
//        return 100;                                        // now we are fine we continue on happy path ... then ... then
        throw new RuntimeException("this is beyond any repair");  // now it blows and there are not any exceptionally after so it exits
    }

    public static void process(CompletableFuture<Integer> future) {
        future.exceptionally(throwable -> handle(throwable))           // now completeExceptionally it will execute and return 40000
                .thenApply(data -> data * 2)               // formed a pipeline
                .thenApply(data -> data + 1)
                .thenAccept(System.out::println);
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        future.completeOnTimeout(555, 3, TimeUnit.SECONDS);            // if it does not finish on time it'll return 555
        process(future);
        sleep(2000);
        //future.complete(2);
        //future.completeExceptionally(new RuntimeException("Smth went wrong!"));
        sleep(5000);
    }

    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

}

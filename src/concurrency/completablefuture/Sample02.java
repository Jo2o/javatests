package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Sample02 {

    public static ForkJoinPool forkJoinPool = new ForkJoinPool(10);

    public static int compute() {
        System.out.println("compute: " + Thread.currentThread());
        return 2;
    }

    public static void printIt(int value) {
        System.out.println(value);
        System.out.println("printIt: " + Thread.currentThread());
    }

    public static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(Sample02::compute, forkJoinPool);
    }

    public static void main(String[] args) {
        System.out.println("main: " + Thread.currentThread());
        create()
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 2)
                .thenAccept(Sample02::printIt);
    }

}

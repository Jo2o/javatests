package concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public class Sample01 {

    //public static ForkJoinPool forkJoinPool = new ForkJoinPool(10);

    public static int compute() {
        //System.out.println("compute: " + Thread.currentThread());
        return 2;
    }

    public static void printIt(int value) {
        System.out.println(value);
        //System.out.println("printIt: " + Thread.currentThread());
    }

    public static CompletableFuture<Integer> create() {
        return CompletableFuture.supplyAsync(() -> compute()
                //, forkJoinPool
        );
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main: " + Thread.currentThread());
        //CompletableFuture<Integer> cf = create();    // this thread executed, finished, worked - does not waste time
        //Thread.sleep(1000);
        create()
                .thenAccept(data -> printIt(data))
                .thenRun(() -> System.out.println("all done"))
                .thenRun(() -> System.out.println("not really"));       // never completes like train - you get off but don't worry where train ends . . .
    }

}

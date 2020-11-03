package concurrency.joiningthreads;

public class Main {

    public static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread[] threads = new Thread[5];

        for (int i=0; i < threads.length; i++) {
            threads[i] = new Thread(new NotSyncCounter(), "thread-" + i);
            threads[i].start();
        }

        for (int i=0; i < threads.length; i++) {
            threads[i].join();
        }

        System.out.println("\nProgram finished with counter: " + counter);
    }
}

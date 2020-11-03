package concurrency.joiningthreads;

public class NotSyncCounter implements Runnable {

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " - counter before: " + Main.counter);
        if (Main.counter < 10) {
            Main.counter++;
        }
        System.out.println(Thread.currentThread().getName() + " - counter after: " + Main.counter);
    }

}

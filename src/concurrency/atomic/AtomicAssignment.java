package concurrency.atomic;

import java.text.SimpleDateFormat;
import java.util.*;

public class AtomicAssignment implements Runnable {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
    private static Map<String, String> configuration = new HashMap<>();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Map<String, String> currConfig = configuration; // ATOMIC READ STEP
            String value1 = currConfig.get("key-1");
            String value2 = currConfig.get("key-2");
            String value3 = currConfig.get("key-3");
            if (!(value1.equals(value2) && value2.equals(value3))) {
                throw new IllegalStateException("Values are not equal.");
            }
            try {
                System.out.println(Thread.currentThread().getName() + currConfig);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void readConfig() {
        Map<String, String> newConfig = new HashMap<>();
        Date now = new Date();
        newConfig.put("key-1", format.format(now));
        newConfig.put("key-2", format.format(now));
        newConfig.put("key-3", format.format(now));
        configuration = newConfig;                       // ATOMIC SWITCH TO NEW MAP
        System.out.println("reading config: " + configuration);
    }

    public static void main(String[] args) throws InterruptedException {
        readConfig();

        Thread configThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                readConfig();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"configuration-thread");

        configThread.start();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new AtomicAssignment(), "thread-" + i);
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }

        configThread.join();

        System.out.println("[" + Thread.currentThread().getName() + "] All threads  - have finished.");
    }

}

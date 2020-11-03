package sk.jo2o.javatests;

import java.security.SecureRandom;
import java.util.ArrayList;

public class ThreadLocalExample {

    public static void main(String[] args) {
        MyRunnable runnableInstance = new MyRunnable();

        new ArrayList<>();

        new Thread(runnableInstance).start();
        new Thread(runnableInstance).start();
    }

    public static class MyRunnable implements Runnable {
        private ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
        @Override
        public void run() {
            integerThreadLocal.set(new SecureRandom().nextInt());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println(integerThreadLocal.get());
        }
    }

}

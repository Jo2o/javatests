package sk.jo2o.javatests.threadjoin;

import java.util.Random;

public class Join implements Runnable {

    private Random rand = new Random(System.currentTimeMillis());

    @Override
    public void run() {
        //simulate some CPU expensive task
        for(int i=0; i<100000000; i++) {
            rand.nextInt();
        }
        System.out.println('[' + Thread.currentThread().getName() + "] finished.");
    }

}

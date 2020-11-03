package sk.jo2o.javatests.threadjoin;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new Join(), "joinThread-" + i);
            threads[i].start();
        }

        for(int i=0; i<threads.length; i++) {
            threads[i].join();
        }

        System.out.println('[' + Thread.currentThread().getName() + "] All threads have finished.");
    }

}

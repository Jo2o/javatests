package sk.jo2o.javatests.lambdas;

public class LambdaRunnable {


    public static void main(String[] args) {

/* RUNNABLE CLASS */
//        new Thread(new CodeToRun()).start();

/* ANONYMOUS RUNNABLE CLASS */
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Printing from Runnable!");
//            }
//        }).start();

/* LAMBDA 1 LINE */
//        new Thread(() -> System.out.println("Printing from Runnable!")).start();

/* LAMBDA MORE LINES */
        new Thread(() -> {
            System.out.println("1");
            System.out.println("2");
            return;
        }).start();


    }

    static class CodeToRun implements Runnable {
        @Override
        public void run() {
            System.out.println("Printing from Runnable!");
        }

    }

}

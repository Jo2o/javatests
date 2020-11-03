package sk.jo2o.javatests.forkjoinpool;

public class Main {

    public static void main(String[] args) {
        double[] d = {4.2, 0.2, 0.6};
        System.out.println(new ForkJoinTask(0, 2, d).compute());
    }

}

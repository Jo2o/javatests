package sk.jo2o.javatests.forkjoinpool;

import java.util.concurrent.RecursiveTask;


public class ForkJoinTask extends RecursiveTask<Integer> {

    private int first;
    private int last;
    private double[] d;

    public ForkJoinTask(int first, int last, double[] d) {
        this.first = first;
        this.last = last;
        this.d = d;
    }

    @Override
    protected Integer compute() {
        int subCount;
        if (last - first < 10) {
            subCount = 0;
            for (int i = first; i <= last; i++) {
                if (d[i] < 0.5) {
                    subCount++;
                }
            }
        } else {
            int mid = (first + last) >>> 1; // divide by 2
            ForkJoinTask left = new ForkJoinTask(first, mid, d);
            left.fork();
            ForkJoinTask right = new ForkJoinTask(mid + 1, last, d);
            right.fork();

            subCount = left.join();
            subCount += right.join();
        }

        return subCount;
    }

}

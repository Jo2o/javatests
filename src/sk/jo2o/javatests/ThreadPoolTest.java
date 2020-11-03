package sk.jo2o.javatests;

import static java.lang.Integer.MAX_VALUE;
import static java.util.concurrent.TimeUnit.SECONDS;

import java.util.concurrent.*;

public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        double[] d = createArray();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, MAX_VALUE, SECONDS, new LinkedBlockingQueue<>());
        Future[] f = new Future[4];
        int size = d.length / 4;
        for (int i = 0; i < 3; i++) {
//            f[i] = threadPoolExecutor.submit(new ThreadPoolTest.ThreadPoolExecutorTask(i*size, (i+1)*(size-1) ));
        }

        int n = 0;
        for (int i = 0; i < 4; i++) {
            n += (int) f[i].get();
        }

    }

    private static double[] createArray() {
        return new double[] {0.1, 0.5, 0.2, 6.5};
    }

    public class ThreadPoolExecutorTask implements Callable<Integer> {
        private int first;
        private int last;

        public ThreadPoolExecutorTask(int first, int last) {
            this.first = first;
            this.last = last;
        }

        @Override
        public Integer call() throws Exception {
            int subCount = 0;
            for (int i = first; i <= last; i++) {
//                if (d[i] < 0.5) {
//                    subCount++;
//                }
            }
            return subCount;
        }
    }

}

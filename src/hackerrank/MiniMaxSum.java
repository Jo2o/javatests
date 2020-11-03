package hackerrank;

import java.util.*;

public class MiniMaxSum {

    public static void main(String[] args) {
        int[] arr = {5,5,5,5,5};
        miniMaxSum(arr);
    }

    static void miniMaxSum(int[] arr) {
        IntSummaryStatistics stat = Arrays.stream(arr).summaryStatistics();
        long minElement = stat.getMin();
        long maxElement = stat.getMax();
        long sameElementsSum = stat.getSum() - minElement;
        long minSum = 0;
        long maxSum = 0;
        if (minElement == maxElement) {
            System.out.println(sameElementsSum + " " + sameElementsSum);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            long number = arr[i];
            if (number != minElement) {
                maxSum += number;
            }
            if (number != maxElement) {
                minSum += number;
            }
        }
        System.out.println(minSum + " " + maxSum);
    }


}

package hackerrank;

import java.util.*;

public class HackerRankLongestDiff1SubArray {

    public static void main(String[] args) {
        System.out.println(longestSubarray(Arrays.asList(1,2,3,4,5,4,4,5,2,6)));
    }

    public static int longestSubarray(List<Integer> arr) {
        if ((arr == null) || arr.isEmpty() || (arr.size() == 1)) {
            return 0;
        }
        if ((arr.size() == 2) && (Math.abs(arr.get(0) - arr.get(1)) == 1)) {
            return 2;
        }
        if (arr.size() == 2) {
            return 1;
        }

        int maxResult = 0;
        int tmpResult = 0;

        int previous = arr.get(0);
        List<Integer> buffer = new ArrayList<>();
        buffer.add(previous);

        for (int i = 1; i < (arr.size() - 1); i++) {
            previous = arr.get(i - 1);
            int current = arr.get(i);
            if (isDifferentMaxByOne(previous, current) && hasMaxTwoDifferentElements(current, buffer)) {
                tmpResult++;
                if (tmpResult > maxResult) {
                    maxResult = tmpResult;
                }
            } else {
                tmpResult = 1;
            }
            previous = arr.get(i-1);
        }
        return maxResult;
    }

    private static boolean hasMaxTwoDifferentElements(int current, List<Integer> buffer) {
//        if (buffer) {
//
//        }
        return true;
    }

    private static boolean isDifferentMaxByOne(int previous, int current) {
        if (Math.abs(current - previous) <= 1) {
            return true;
        }
        return false;
    }

}

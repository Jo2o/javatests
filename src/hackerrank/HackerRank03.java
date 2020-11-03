package hackerrank;

import java.util.Arrays;
import java.util.List;

public class HackerRank03 {

    public static void main(String[] args) {
        System.out.println(countPairs(Arrays.asList(10,7,2,8,3)));
    }

    public static long countPairs(List<Integer> arr) {
        if (arr == null || arr.size() == 1) {
            return 0;
        }

        int result = 0;



        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if(isPowerOfTwo(arr.get(i) & arr.get(j))) {
                    result++;
                }
            }
        }
        return result;
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && ((n & (n - 1)) == 0);
    }
}

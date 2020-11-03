package codility;

import java.util.*;

public class OddNumberInArray {

    public static void main(String[] args) {
        int[] arr = {9, 3, 9, 3, 9, 7, 9};
        //int[] arr = {8,1,2,1,2};
        System.out.println(solution(arr));
    }

    static int solution(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        Arrays.sort(A);
        int i = 0;
        for (; i < (A.length - 1); i +=2) {
            if (A[i] != A[i+1]) {
                return A[i];
            }
        }
        return A[i];
    }
}

package codility;

import java.util.*;

public class AssecoMaxDevelopers {

    public static void main(String[] args) {
//        int[] A = {4,8,5,3,2};
//        int[] B = {2,3,4,5,1};
//        int F = 3;

//        int[] A = {7, 1, 4, 4};
//        int[] B = {5, 3, 4, 3};
//        int F = 2;

        int[] A = {4,2,1};
        int[] B = {2,5,3};
        int F = 2;

        System.out.println(solution(A, B, F));
    }

    static int solution(int[] A, int[] B, int F) {
        if (F == 0) {
            return 0;
        }
        int sum = 0;

        int feCount = F;
        int beCount = A.length - F;

        for (int i = 0; i < A.length; i++) {
            if ((A[i] > B[i]) && (feCount != 0)) {
                sum += A[i];
                feCount--;
            } else if ((A[i] < B[i]) && (beCount != 0)) {
                sum += B[i];
                beCount--;
            } else {
                sum += A[i];
                feCount--;
            }
        }
        return sum;
    }

}

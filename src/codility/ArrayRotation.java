package codility;

import java.util.Arrays;

public class ArrayRotation {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();
        Arrays.stream(solution(array, 6)).forEach(System.out::print);
    }

    private static int[] solution(int[] A, int K) {
        if (A == null) {
            return null;
        }
        if (A.length == 1) {
            return A;
        }
        if (K == 0) {
            return A;
        }
        int arrayLength = A.length;
        int moveToRightNumber = K % arrayLength;
        if (moveToRightNumber == 0) {
            return A;
        }
        int[] result = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            if ((i + K) < arrayLength) {
                result[i+K] = A[i];
            }
            if ((i + K) >= arrayLength) {
                result[i + K - arrayLength] = A[i];
            }
        }
        return result;
    }

}

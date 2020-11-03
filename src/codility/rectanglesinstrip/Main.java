package codility.rectanglesinstrip;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

//        int[] arr1 = {1, 2, 3, 4};
//        int[] arr2 = {2, 3, 4, 5};

        int[] arr1 = {2,3,1,3};
        int[] arr2 = {2,3,1,3};

        System.out.println(solution(arr1, arr2));

    }

    public static int solution(int[] A, int[] B) {
        if ((A == null) || (B == null) || (A.length == 0) || (B.length == 0)) {
            return 0;
        }
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int side1 = A[i];
            int side2 = B[i];
            if (frequencyMap.get(side1) != null) {
                frequencyMap.put(side1, frequencyMap.get(side1) + 1);
            } else {
                frequencyMap.put(side1, 1);
            }
            if (A[i] == B[i]) {
                continue;
            }
            if (frequencyMap.get(side2) != null) {
                frequencyMap.put(side2, frequencyMap.get(side2) + 1);
            } else {
                frequencyMap.put(side2, 1);
            }
        }
        int max = 0;
        for (int value : frequencyMap.values()) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }



}

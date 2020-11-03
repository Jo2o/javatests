package hackerrank;

import java.util.*;

public class HackerRankDiagonalSum {

    public static void main(String[] args) {

        List<Integer> line1 = Arrays.asList(11,2,4);
        List<Integer> line2 = Arrays.asList(4,5,6);
        List<Integer> line3 = Arrays.asList(10,8,-12);

        List<List<Integer>> arr = new ArrayList<>();
        arr.add(line1);
        arr.add(line2);
        arr.add(line3);

        System.out.println(diagonalDifference(arr));

    }



    public static int diagonalDifference(List<List<Integer>> arr) {
        int diag1Sum = 0;
        int diag2Sum = 0;

        int rowCounter = 0;
        for (List<Integer> row : arr) {
            int columnCounter = 0;
            for (Integer number : row) {

                if (rowCounter == columnCounter) {
                    diag1Sum += number;
                }

                if (row.size() - 1 - rowCounter == columnCounter) {
                    diag2Sum += number;
                }
                columnCounter++;
            }
            rowCounter++;
        }

        return Math.abs(diag1Sum - diag2Sum);

    }




}

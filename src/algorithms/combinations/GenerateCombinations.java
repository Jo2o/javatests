package algorithms.combinations;

import static java.util.stream.Collectors.joining;

import java.util.*;

public class GenerateCombinations {
    /**
     *  C(n, r) = n! / ((n - r)! * r!)
     */
    public static void main(String[] args) {
        List<int[]> result = new GenerateCombinations().generate(4, 3);
        result.stream()
                .map(GenerateCombinations::arrayToString)
                .forEach(System.out::println);
    }

    private static String arrayToString(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .map(Objects::toString)
                .collect(joining(",", "[", "]"));
    }

    public List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        int[] combination = new int[r];

        // init with lowest combination
        for (int i = 0; i < r; i++) {
            combination[i] = i;
        }

        while (combination[r - 1] < n) {
            combinations.add(combination.clone());
            int t = r - 1;
            while ((t != 0) && (combination[t] == ((n - r) + t))) {
                t--;
            }
            combination[t]++;
            for (int i = t + 1; i < r; i++) {
                combination[i] = combination[i - 1] + 1;
            }
        }

        return combinations;
    }

}

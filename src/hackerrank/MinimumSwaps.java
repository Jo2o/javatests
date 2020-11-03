package hackerrank;

import static java.util.stream.Collectors.toList;

import java.util.*;
import java.util.stream.IntStream;

public class MinimumSwaps {

    public static void main(String[] args) {
        minimumSwaps(getHugeArray());
    }

    static void minimumSwaps(int[] q) {
        List<Integer> original = Arrays.stream(q).boxed().collect(toList());
        List<Integer> ordered = IntStream.rangeClosed(1, original.size()).boxed().collect(toList());
        int queueSize = original.size();
        int swapCount = 0;

        for (int j = 1; j <= queueSize; j++) {
            int originalIdxOfJ = original.indexOf(j);
            int orderedIdxOfJ = ordered.indexOf(j);
            if (originalIdxOfJ == orderedIdxOfJ) {
                continue;
            }
            Collections.swap(original, originalIdxOfJ, orderedIdxOfJ);
            swapCount++;

            if (ordered.equals(original)) {
                System.out.println(swapCount);
                return;
            }
        }
    }

    private static int[] getHugeArray() {
        return new int[] {1,3,5,2,4,6,7};
    }

}

package hackerrank;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.*;
import java.util.Map.Entry;

public class MigratoryBirds {

    public static void main(String[] args) {
        System.out.println(migratoryBirds(Arrays.asList(5, 4, 6, 8, 6, 3, 3, 1)));
    }

    static int migratoryBirds(List<Integer> list) {
        int result = 0;
        if ((list == null) || list.isEmpty()) {
            return result;
        }
        Map<Integer, Long> map = list.stream()
                .collect(groupingBy(Integer::intValue, counting()));
        long max = map.values().stream()
                .max(Long::compareTo)
                .orElse(0L);
        result = Integer.MAX_VALUE;
        for (Entry<Integer, Long> entry : map.entrySet()) {
            if ((max == entry.getValue()) && (entry.getKey() < result)) {
                    result = entry.getKey();
            }
        }
        return result;
    }

}

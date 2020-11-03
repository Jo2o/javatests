package modernjava.streams;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class FlatMapTest {

    private static List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

    public static void main(String[] args) {

        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println(words);
        System.out.println(uniqueCharacters);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(4, 5);
        List<int[]> pairs =
                numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                              .filter(j -> ((i + j) % 3) == 0)
                                              .map(j -> new int[]{i, j})
                        )
                        .collect(toList());

        pairs.forEach(pair -> System.out.println(pair[0] + ":" + pair[1]));
    }

}

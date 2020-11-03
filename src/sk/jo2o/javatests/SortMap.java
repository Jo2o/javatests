package sk.jo2o.javatests;

import java.util.*;

public class SortMap {

    public static void main(String[] args) {

        Map<Integer, String> unsortedMap = new HashMap<>();
        unsortedMap.put(50, "eks");
        unsortedMap.put(14, "zet");
        unsortedMap.put(5, "be");
        unsortedMap.put(111, "ce");
        unsortedMap.put(57, "ypsilon");
        System.out.println(unsortedMap);

        TreeMap<Integer, String> sortedMap = new TreeMap<>(unsortedMap);
        System.out.println(sortedMap);


        System.out.println("Unsorted: " + unsortedMap.keySet());
        SortedSet<Integer> sortedKeys = new TreeSet<>(unsortedMap.keySet());
        System.out.println("Sorted: " + sortedKeys);

        List<Integer> sortedKeys2 = new ArrayList<>(unsortedMap.keySet());
        Collections.sort(sortedKeys2);
        System.out.println("Sorted 2: " + sortedKeys2);


        SortedSet<Integer> sortedIntegers = new TreeSet<>();
        sortedIntegers.add(5);
        sortedIntegers.add(50);
        sortedIntegers.add(10);
        sortedIntegers.add(30);
        sortedIntegers.add(1);
        sortedIntegers.forEach(System.out::println);

    }

}

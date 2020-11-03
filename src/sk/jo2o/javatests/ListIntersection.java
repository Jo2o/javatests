package sk.jo2o.javatests;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ListIntersection {

    private static List<DayOfWeek> NOT_WORKING_DAYS =  Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY);

    public static void main(String[] args) {
        List<String> list01 = Arrays.asList("005");
        //List<String> list01 = Arrays.asList("a", "b", "c");
        List<String> list02 = Arrays.asList("x", "a", "y", "b", "z", "c");

        Set<String> intersection = list01.stream()
                .distinct()
                .filter(list02::contains)
                .collect(Collectors.toSet());

        System.out.println(intersection);
    }

}

package modernjava.lambdas_method_references_practice;

import java.util.*;

import modernjava.appleprittyprint.Apple;

public class FromAnonymousToComparatorComparing {

    private static List<Apple> inventory = Arrays.asList(new Apple("yellow", 160),
        new Apple("yellow", 260),
        new Apple("green", 20),
        new Apple("green", 160),
        new Apple("yellow", 10));

    public static void main(String[] args) {

        // anonymous class
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return Integer.valueOf(a1.getWeight()).compareTo(Integer.valueOf(a2.getWeight()));
            }
        });

        // lambda
        inventory.sort((a1, a2) -> Integer.valueOf(a1.getWeight()).compareTo(Integer.valueOf(a2.getWeight())));

        // Comparator.comparing
        inventory.sort(Comparator.comparing(Apple::getWeight));

    }

}

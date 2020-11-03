package modernjava.from_passing_methods_to_lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("yellow", 160));
        apples.add(new Apple("yellow", 260));
        apples.add(new Apple("green", 20));
        apples.add(new Apple("green", 160));
        apples.add(new Apple("yellow", 10));

        List<Apple> greens = filterApples(apples, Apple::isGreen); // passed as function to function
        System.out.println("greens: " + Arrays.toString(greens.toArray()));
        List<Apple> heavies = filterApples(apples, Apple::isHeavy);
        System.out.println("heavies: " + Arrays.toString(heavies.toArray()));

        List<Apple> greenHeavies = filterApples(apples, a -> a.getColor().equalsIgnoreCase("green") && a.getWeight() > 100); // passed as anonym function to function
        System.out.println("greens & heavies: " + Arrays.toString(greenHeavies.toArray()));


    }

    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) { // normalne tu mozes dat fnc :D nemusi implementovat Predicate
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

}

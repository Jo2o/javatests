package modernjava.appleprittyprint;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Write a prettyPrintApple method that takes a List of Apples and that can be parameterized with multiple ways to generate
 * a String output from an apple (a bit like multiple customized toString methods).
 * For example, you could tell your prettyPrintApple method to print only the weight of each apple.
 * In addition, you could tell your prettyPrintApple method to print each apple individually and mention whether it’s heavy or light.
 */
public class Main {

    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple("yellow", 160));
        apples.add(new Apple("yellow", 260));
        apples.add(new Apple("green", 20));
        apples.add(new Apple("green", 160));
        apples.add(new Apple("yellow", 10));

        prettyPrintApple(apples, apple -> System.out.println("COLOOOOOOOOR: " + apple.getColor() + "!!!!!"));

        //apples.sort((a1, a2) -> a1.getWeight() > a2.getWeight());
    }

    public static void prettyPrintApple(List<Apple> inventory, Consumer<Apple> appleConsumer) {
        for(Apple apple : inventory) {
            appleConsumer.accept(apple);
        }
    }

}

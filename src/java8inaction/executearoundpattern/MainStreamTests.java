package java8inaction.executearoundpattern;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.*;

public class MainStreamTests {

    public static void main(String[] args) {
        new MainStreamTests().run();
    }

    public void run() {
        Apple a1 = new Apple("green", "sweet");
        Apple a2 = new Apple("red", null);
        Apple a3 = new Apple("orange", "sweet");
        Apple a4 = new Apple("yellow", "sweet");
        Apple a5 = new Apple("black", "sweet");
        Apple a6 = new Apple("blue", "bitter");
        List<Apple> as = Arrays.asList(a1, a2, a3, a4, a5, a6);

        List<Apple> result = as.stream()
                .map(apple -> {
                    apple.setColor("pink");
                    return apple;
                })
                .collect(toList());

        System.out.println("\n-------------------------------------\n" + result);

        List<Apple> result2 = as.stream()
                .peek(apple -> apple.setColor("purple"))
                .collect(toList());

        System.out.println("\n-------------------------------------\n" + result2);

        Map<String, List<Apple>> result3 = as.stream()
                .filter(apple -> apple.getTaste() != null)
                .collect(groupingBy(Apple::getTaste));

        System.out.println("\n-------------------------------------\n" + result3);
    }

    private class Apple {
        private String color;
        private String taste;
        private Apple(String color, String taste) {
            this.color = color;
            this.taste = taste;
        }
        public String getTaste() {
            return taste;
        }
        public void setColor(String color) {
            this.color = color;
        }
        @Override
        public String toString() {
            return "Apple{" + "color='" + color + "\', taste='" + taste + "\'}";
        }
    }

}

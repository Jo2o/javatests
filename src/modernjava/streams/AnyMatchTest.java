package modernjava.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AnyMatchTest {

    public static void main(String[] args) {
        Map<String, Apple> appleMap = new HashMap<>();
        appleMap.put("a", null);
        appleMap.put("b", null);
        appleMap.put("c", null);
        appleMap.put("d", null);
        appleMap.put("e", new Apple("r", 20));
        appleMap.put("f", null);
        appleMap.put("g", null);
        appleMap.put("h", null);
        appleMap.put("i", null);

        for (Apple a : appleMap.values()) {
            if (a != null) {
                System.out.println("found one");
            }
        }

        System.out.println(
        appleMap.values().stream()
                .anyMatch(Objects::isNull)
        );
    }


}

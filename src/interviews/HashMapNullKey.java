package interviews;

import java.util.HashMap;
import java.util.Map;

public class HashMapNullKey {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put(null, "I have a NULL key.");
        map.put("key", "I have a KEY key.");
        System.out.println(map);
    }
}

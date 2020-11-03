package sk.jo2o.javatests;

import java.util.HashMap;
import java.util.Map;

public class MapAddMap {

    public static void main(String[] args) {
        Map<String, String> mapA = new HashMap<>();
        mapA.put("ak", "aV");
        Map<String, String> mapB = new HashMap<>();
        mapB.put("bk", "bV");

        mapA.putAll(mapB);
        System.out.println(mapA);
    }

}

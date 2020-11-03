package sk.jo2o.javatests;

import java.util.ArrayList;
import java.util.List;

public class ListToString {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        System.out.println(String.join(", ", list));
        System.out.println(list);
    }

}

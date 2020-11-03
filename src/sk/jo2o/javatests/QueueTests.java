package sk.jo2o.javatests;

import java.util.*;

public class QueueTests {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a", "b", "c", "d");
        Queue<String> queue = new LinkedList<>(strList);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

}

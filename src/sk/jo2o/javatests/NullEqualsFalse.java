package sk.jo2o.javatests;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NullEqualsFalse {

    private static List<DayOfWeek> NOT_WORKING_DAYS =  Arrays.asList(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY);

    public static void main(String[] args) {
        System.out.println(Objects.equals(null, Boolean.FALSE));
        System.out.println(Objects.equals(null, false));
        System.out.println(Objects.equals(null, true));
        System.out.println(Objects.equals(Boolean.FALSE, false));
        System.out.println("----------------------------------");
        System.out.println("abc".equals("abc"));
        System.out.println("abc".equals("2"));
        System.out.println("abc".equals(null));
    }



}

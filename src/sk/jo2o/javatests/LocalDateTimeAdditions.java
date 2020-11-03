package sk.jo2o.javatests;

import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeAdditions {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.of(2020, 6, 17, 12, 01, 01);
        System.out.println(dateTime);
//        System.out.println("---------------------");
//        System.out.println(dateTime.plusWeeks(1));
//        System.out.println(dateTime.plusWeeks(2));
//        System.out.println(dateTime.plusWeeks(3));
//        System.out.println(dateTime.plusWeeks(4));
//        System.out.println(dateTime.plusWeeks(5));
//        System.out.println(dateTime.plusWeeks(6));
//        System.out.println(dateTime.plusWeeks(7));
//        System.out.println("---------------------");
//        System.out.println(dateTime.plusMonths(1));
//        System.out.println(dateTime.plusMonths(2));
//        System.out.println(dateTime.plusMonths(3));
//        System.out.println(dateTime.plusMonths(4));
        System.out.println("---------------------");

        System.out.println(dateTime.getDayOfWeek().getValue());
        System.out.println(DayOfWeek.of(2));
        System.out.println(dateTime.with(previousOrSame(DayOfWeek.of(2))));
        System.out.println(dateTime.with(previousOrSame(DayOfWeek.of(3))));
        System.out.println(dateTime.with(previousOrSame(DayOfWeek.of(4))));

//        System.out.println(dateTime.with(previousOrSame(.of(4))));
//        System.out.println("---------------------");

    }

}

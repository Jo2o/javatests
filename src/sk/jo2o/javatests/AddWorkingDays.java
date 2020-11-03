package sk.jo2o.javatests;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class AddWorkingDays {

    private static List<DayOfWeek> NOT_WORKING_DAYS =  Arrays.asList(DayOfWeek.FRIDAY, DayOfWeek.SATURDAY);

    public static void main(String[] args) {
        int daysToAdd = 2;
        LocalDate from = LocalDate.now().minusDays(1);
        System.out.println("Adding " + daysToAdd + " working days to " + from + " which is " + from.getDayOfWeek() );
        LocalDateTime result = addWorkingDays(addWorkingDays(from, daysToAdd),1).atStartOfDay();

        result = result.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toLocalDateTime();

        System.out.println("Result: " + result + " which is " + result.getDayOfWeek());
    }


    private static LocalDate addWorkingDays(LocalDate date, int daysToAdd) {
        LocalDate result = date;
        for (int i = 0; i < daysToAdd; i++) {
            while (NOT_WORKING_DAYS.contains(result.plusDays(1).getDayOfWeek())) {
                result = result.plusDays(1);
            }
            result = result.plusDays(1);
        }
        return result;
    }


//    private static LocalDate addWorkingDays(LocalDate date, int daysToAdd) {
//        LocalDate result = date.plusDays(1); // rounded to full day
//        for (int i = 0; i <= daysToAdd; i++) {
//            result = result.plusDays(1);
//            if (NOT_WORKING_DAYS.contains(result.getDayOfWeek())) {
//                result = result.plusDays(1);
//            }
//        }
//        return result;
//    }

}

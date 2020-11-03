package sk.jo2o.javatests;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class DateUtcConverter {

    private static final ZoneId UTC_ZONE = ZoneId.of("UTC");

    public static void main(String[] args) {

        LocalDate localDateNow = LocalDate.now();
        LocalDate localDateNowUtc = LocalDate.now(UTC_ZONE);

        System.out.println(localDateNow);
        System.out.println(localDateNowUtc);

        LocalDateTime localDateTimeNow = LocalDateTime.now();
        LocalDateTime localDateTimeNowUtc = LocalDateTime.now(UTC_ZONE);

        System.out.println(localDateTimeNow);
        System.out.println(localDateTimeNowUtc);

        Long nowLongFromDate = new Date().getTime();
        Long nowLongFromLocalDateTime = LocalDateTime.now().atZone(UTC_ZONE).toInstant().toEpochMilli();
        System.out.println(nowLongFromDate);
        System.out.println(nowLongFromLocalDateTime);

        System.out.println("\n--------- MY & UTC ---------");
        LocalDateTime myNow = LocalDateTime.now();
        System.out.println("myNow: " + myNow);
        LocalDateTime myNowAsUtc = myNow.atZone(UTC_ZONE).toLocalDateTime();
        System.out.println("myNowAsUtc: " + myNowAsUtc);
        System.out.println("qCorrect: " + myNow.atZone(ZoneId.systemDefault()).withZoneSameInstant(UTC_ZONE));




        System.out.println(LocalDate.now(UTC_ZONE));
        System.out.println(LocalDateTime.now());
        System.out.println(LocalDateTime.now(UTC_ZONE));


        System.out.println();
        System.out.println(Date.from(LocalDateTime.now().atZone(UTC_ZONE).toInstant()));
        System.out.println(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));

        System.out.println();
        System.out.println(LocalDateTime.now());
        System.out.println(OffsetDateTime.now());
        System.out.println(OffsetDateTime.now(UTC_ZONE));

        System.out.println("\n--------- CONVERT ---------");
        LocalDate nowLocalDate = LocalDate.now();
        System.out.println(nowLocalDate);

        System.out.println(nowLocalDate.atTime(LocalTime.now(ZoneId.of("Etc/GMT+12")) ));
        System.out.println(nowLocalDate.atTime(LocalTime.now(ZoneId.of("Etc/GMT+12"))).toLocalDate());

        System.out.println("\n--------- BANGLADESH ---------");
        LocalDate nowLocalDate02 = LocalDate.now();
        System.out.println(nowLocalDate02);

        System.out.println(nowLocalDate.atTime(LocalTime.now() ));
        System.out.println(nowLocalDate.atTime(LocalTime.now(UTC_ZONE)).toLocalDate());

        System.out.println("\n--------- DATE 2 INSTANT ---------");
        Date testDate = new Date();
        System.out.println(testDate.toInstant().atZone(UTC_ZONE).toLocalDateTime());
        System.out.println(testDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());

        System.out.println("\n--------- LOCALDATE 2 UTC LOCALDATE ---------");
        LocalDate inLocalDate = LocalDate.of(2019, 3, 8);
        LocalDate result = inLocalDate;
        LocalDateTime utcLocalDateTime = LocalDateTime.of(2019,3,7,20,00);
                //LocalDateTime.now(UTC_ZONE);
        if (!inLocalDate.equals(utcLocalDateTime.toLocalDate())) {
            result = utcLocalDateTime.toLocalDate();
        }
        System.out.println(inLocalDate);
        System.out.println(utcLocalDateTime);
        System.out.println(result);


    }


}

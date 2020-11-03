package sk.jo2o.javatests;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

public class TimeZones {

    private static final ZoneId BANGLADESH_ZONE = TimeZone.getTimeZone("Asia/Dhaka").toZoneId();


    public static void main(String[] args) {
//        System.out.println(Arrays.asList(TimeZone.getAvailableIDs()));
        ZoneId bangladeshZone = TimeZone.getTimeZone("Asia/Dhaka").toZoneId();
        System.out.println(LocalDateTime.now(bangladeshZone).getHour());

        LocalDateTime dateTime = LocalDateTime.now(BANGLADESH_ZONE);
        String strDate = dateTime.format(DateTimeFormatter.ofPattern("yyMMdd-HHmmss"));
        System.out.println(strDate);
    }

}

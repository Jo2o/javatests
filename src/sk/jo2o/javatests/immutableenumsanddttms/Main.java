package sk.jo2o.javatests.immutableenumsanddttms;

import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        EnumHolder enumHolder = new EnumHolder();
        enumHolder.setReportState(ReportState.STARTED);

        ReportState var = enumHolder.getReportState();
        var = ReportState.DB_DATA_ACQUIRED;
        System.out.println("New value of var: " + var);
        System.out.println("Value in enumHolder: " + enumHolder.getReportState());

        System.out.println("------------------------------");

        DateTimeHolder dateTimeHolder = new DateTimeHolder();
        dateTimeHolder.setLocalDateTime(LocalDateTime.now());

        LocalDateTime tmp = dateTimeHolder.getLocalDateTime();
        tmp = LocalDateTime.of(2020, 10, 14, 14, 14, 14);

        System.out.println("New value of tmp: " + tmp);
        System.out.println("Value in dateTimeHolder: " + dateTimeHolder.getLocalDateTime());

        System.out.println("------------------------------");

        IntegerHolder integerHolder = new IntegerHolder();
        integerHolder.setInteger(Integer.valueOf("258"));

        Integer tmpInt = integerHolder.getInteger();
        tmpInt = Integer.valueOf("222");

        System.out.println("New value of tmpInt: " + tmpInt);
        System.out.println("Value in integerHolder: " + integerHolder.getInteger());
    }

}

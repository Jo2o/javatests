package sigp.interview.mikus;

import java.time.LocalDate;

public class LocalDateMinusZero {

    public static void main(String[] args) {
//        System.out.println(LocalDate.now().minusDays(2));
//        System.out.println(LocalDate.now().minusDays(0));
//        System.out.println(LocalDate.now().plusDays(0));

        Integer myInt = 0;
        Integer myNullInt = null;
        myInt += myNullInt;
        System.out.println(myInt);
    }
}

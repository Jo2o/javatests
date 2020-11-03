package sk.jo2o.javatests;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalTests {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("6546984.89");
        System.out.println(bigDecimal.intValue());
        System.out.println("------------------------------------------------");

        BigDecimal bg1, bg2;
        bg1 = new BigDecimal("10");
        bg2 = new BigDecimal("3");

        BigDecimal res = bg1.divide(bg2, 2, RoundingMode.HALF_UP);
        System.out.println(res);

        System.out.println(res.compareTo(new BigDecimal("3.32")));

        System.out.println("------------------------------------------------");
        System.out.println(BigDecimal.valueOf(10 / 3.0));
        System.out.println("------------------------------------------------");

        BigDecimal zero = BigDecimal.ZERO;
        BigDecimal augend = BigDecimal.valueOf(165465425, 5);

        System.out.println(zero.add(augend));

    }

}

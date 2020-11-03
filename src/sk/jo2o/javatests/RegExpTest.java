package sk.jo2o.javatests;

public class RegExpTest {

    public static void main(String[] args) {
        System.out.println(stripDecimalZeros("4 564,0000000"));
        System.out.println(stripDecimalZeros("4 564,100"));
        System.out.println(stripDecimalZeros("4"));
        System.out.println(stripDecimalZeros("5.002"));
    }

    private static String stripDecimalZeros(String num) {
        return num.replaceAll(",0+$", "");
    }

}

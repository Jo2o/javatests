package sk.jo2o.javatests.nullLongOperations;

public class NullLongOperations {

    public static void main(String[] args) {
        Long five = Long.valueOf("5");
        Long ten = Long.valueOf("10");
        System.out.println(five + ten);

        NullableLong nullableLong = new NullableLong();
        Long result = nullableLong.add(null);
        System.out.println(result);
    }

}

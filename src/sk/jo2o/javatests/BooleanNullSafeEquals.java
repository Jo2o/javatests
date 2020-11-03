package sk.jo2o.javatests;

public class BooleanNullSafeEquals {

    public static void main(String[] args) {

        Boolean falseB = false;
        Boolean nullB = null;

        System.out.println(Boolean.TRUE.equals(true));
        System.out.println(Boolean.TRUE.equals(null));
        System.out.println(Boolean.TRUE.equals(false));
    }

}

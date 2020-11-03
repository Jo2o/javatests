package sk.jo2o.javatests;

public class SwitchEnums {

    public static void main(String[] args) {
        Enum a = Enum.A;
        Enum e = Enum.E;
        System.out.println(fnc(a));
        System.out.println(fnc(e));
    }


    private static boolean fnc(Enum testEnum) {
        switch (testEnum) {
            case A:
            case B:
            case C:
                return true;
            default:
                return false;
        }
    }

    enum Enum {
        A, B, C, D, E, F;
    }

}

package sk.jo2o.javatests;

public class CharSequenceNullCastString {

    public static void main(String[] args) {
        CharSequence charSequence = null;
        String temp = (String) charSequence;
        System.out.println(temp);
    }

}

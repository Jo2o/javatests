package sk.jo2o.javatests;

public class ReluctantQuantifier {

    public static void main(String[] args) {

        String str = "Helloxmlns=\"http://tempuri.org/\"><dsdfsdsdf";

        System.out.println(str.replaceAll("xmlns=\".*?\"", ""));
        System.out.println(str.replaceAll("xmlns=\"[^\"]*+", ""));
    }

}

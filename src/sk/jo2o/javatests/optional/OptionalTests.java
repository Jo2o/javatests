package sk.jo2o.javatests.optional;

import java.util.Optional;

public class OptionalTests {

    public static void main(String[] args) {
        System.out.println(returnsOptionalStr().orElse("nothing"));

    }


    private static Optional<String> returnsOptionalStr() {
        //return Optional.ofNullable("hello");
        return Optional.ofNullable(null);
    }

}

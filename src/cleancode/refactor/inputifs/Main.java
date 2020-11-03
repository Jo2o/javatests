package cleancode.refactor.inputifs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import cleancode.refactor.inputifs.rules.AlphabeticNameRule;
import cleancode.refactor.inputifs.rules.EmailEmptinessRule;
import cleancode.refactor.inputifs.rules.EmailValidationRule;
import cleancode.refactor.inputifs.rules.ForbiddenEmailDomainsRule;
import cleancode.refactor.inputifs.rules.NameEmptinessRule;
import cleancode.refactor.inputifs.rules.RegistrationRule;

public class Main {

    public static void main(String[] args) {

        /* bad way */
//        register("bad-mail/*//", "name", 123212321);

        /* better way - split to data and rules under interface*/
        RegistrationData registrationData = new RegistrationData();
        registrationData.setEmail("bad-mail/*//");
        registrationData.setAge(123212321);
        registrationData.setName("name");

        /* setup validation you want */
        List<RegistrationRule> rules = new ArrayList<>();
        rules.add(new EmailValidationRule());
        rules.add(new EmailEmptinessRule());
        rules.add(new ForbiddenEmailDomainsRule());
        rules.add(new NameEmptinessRule());
        rules.add(new AlphabeticNameRule());

//        for (RegistrationRule rule : Rules.get()){
//            rule.validate(regData);
//        }

        /* iterate over setup rules */
        for (RegistrationRule rule : rules){
            rule.validate(registrationData);
        }

    }


    private static void register(String email, String name, int age) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        List<String> forbiddenDomains = Arrays.asList("domain1", "domain2");

        if (email == null || email.trim().equals("")) {
            throw new IllegalArgumentException("Email should not be empty!");
        }

        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Email is not a valid email!");
        }

        if (forbiddenDomains.contains(email)) {
            throw new IllegalArgumentException("Email belongs to a forbidden email");
        }

        if (name == null || name.trim().equals("")) {
            throw new IllegalArgumentException("Name should not be empty!");
        }

        if ( !name.matches("[a-zA-Z]+")){
            throw new IllegalArgumentException("Name should contain only characters");
        }

        if ( age <= 18){
            throw new IllegalArgumentException("Age should be greater than 18");
        }

        // More code to do the actual registration
    }

}

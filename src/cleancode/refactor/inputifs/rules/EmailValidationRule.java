package cleancode.refactor.inputifs.rules;

import java.util.regex.Pattern;

import cleancode.refactor.inputifs.RegistrationData;
import cleancode.refactor.inputifs.rules.RegistrationRule;

public class EmailValidationRule implements RegistrationRule {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    public void validate(RegistrationData registrationData) {
        if (!pattern.matcher(registrationData.getEmail()).matches()) {
            throw new IllegalArgumentException("Email is not a valid email!");
        }
    }

}

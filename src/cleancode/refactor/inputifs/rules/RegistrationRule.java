package cleancode.refactor.inputifs.rules;

import cleancode.refactor.inputifs.RegistrationData;

@FunctionalInterface
public interface RegistrationRule {

    void validate(RegistrationData registrationData);

}

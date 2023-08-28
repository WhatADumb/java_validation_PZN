package self.java.validation.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import self.java.validation.enums.CaseMode;

public class CheckCaseValidator implements ConstraintValidator<CheckCase, String> {

    private CaseMode mode;

    @Override
    public void initialize(CheckCase constraintAnnotation) {
        mode = constraintAnnotation.mode();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) return true;

        if (mode == CaseMode.LOWER){
            return s.equals(s.toLowerCase());
        } else if (mode == CaseMode.UPPER) {
            return s.equals(s.toUpperCase());
        }

        return false;
    }
}

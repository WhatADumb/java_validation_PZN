package self.java.validation.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraintvalidation.SupportedValidationTarget;
import jakarta.validation.constraintvalidation.ValidationTarget;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class CheckPasswordParameterValidator implements ConstraintValidator<CheckPasswordParameter, Object[]> {

    int passwordParam;
    int retypePasswordParam;

    @Override
    public void initialize(CheckPasswordParameter constraintAnnotation) {
        passwordParam = constraintAnnotation.passwordParam();
        retypePasswordParam = constraintAnnotation.retypePasswordParam();
    }
    @Override
    public boolean isValid(Object[] objects, ConstraintValidatorContext constraintValidatorContext) {
        String password = (String) objects[passwordParam];
        String retypePassword = (String) objects[retypePasswordParam];

        if (password == null || retypePassword == null){
            return true;
        }

        return password.equals(retypePassword);
    }
}

package self.java.validation.constraints;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import self.java.validation.data.Register;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, Register> {

    private String defaultMessage;

    @Override
    public void initialize(CheckPassword constraintAnnotation) {
        defaultMessage = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Register register, ConstraintValidatorContext context) {
        if(register.getPassword() == null || register.getRetypePassword() == null){
            return true;
        }

        var isValid =  register.getPassword().equals(register.getRetypePassword());

        if (!isValid){
            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate(defaultMessage)
                    .addPropertyNode("password")
                    .addConstraintViolation();

            context.buildConstraintViolationWithTemplate(defaultMessage)
                    .addPropertyNode("retypePassword")
                    .addConstraintViolation();
        }

        return isValid;
    }
}

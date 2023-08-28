package self.java.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CheckPasswordParameterValidator.class})
@Documented
public @interface CheckPasswordParameter {

    int passwordParam();
    int retypePasswordParam();
    String message() default "Password & Retype Password have to be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

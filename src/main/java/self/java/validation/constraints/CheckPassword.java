package self.java.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CheckPasswordValidator.class})
@Documented
public @interface CheckPassword {
    String message() default "Password & Retype Password have to be same";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

package self.java.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import self.java.validation.enums.CaseMode;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CheckCaseValidator.class})
@Documented
public @interface CheckCase {

    CaseMode mode();

    String message() default "Case aren't match";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

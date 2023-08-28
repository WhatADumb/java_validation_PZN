package self.java.validation.constraints;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import self.java.validation.enums.CaseMode;
import self.java.validation.groups.CreditCardPaymentGroup;
import self.java.validation.groups.VirtualAccountPaymentGroup;

import java.lang.annotation.*;

@CheckCase(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},
        message = "{order.orderId.CheckCase}", mode = CaseMode.UPPER)
@NotBlank(groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class},
        message = "{order.orderId.NotBlank}")
@Size(min = 5, max = 10, message = "{order.orderId.Size}",
        groups = {VirtualAccountPaymentGroup.class, CreditCardPaymentGroup.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@Documented
public @interface CheckOrderId {
    String message() default "OrderId is Invalid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

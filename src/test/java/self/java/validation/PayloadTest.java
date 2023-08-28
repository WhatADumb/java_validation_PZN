package self.java.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Payload;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Payment;
import self.java.validation.groups.CreditCardPaymentGroup;
import self.java.validation.payload.EmailErrorPayload;

import java.util.Set;

public class PayloadTest extends UtilValidationTest {
    @Test
    void testPayload() {
        Payment payment = new Payment();
        payment.setOrderId("a001");
        payment.setAmount(1_000_000L);
        payment.setCreditCard("321");

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment, CreditCardPaymentGroup.class);

        for (ConstraintViolation<Payment> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());

            Set<Class<? extends Payload>> payload = violation.getConstraintDescriptor().getPayload();
            for (Class<? extends Payload> aClass : payload) {
                if (aClass == EmailErrorPayload.class) {
                    EmailErrorPayload emailErrorPayload = new EmailErrorPayload();
                    emailErrorPayload.sendEmail(violation);
                }
            }
            System.out.println("=======================");
        }
    }
}

package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Payment;

public class HibernateValidationTest extends UtilValidationTest{
    @Test
    void testPaymentFailed() {
        Payment payment = new Payment();
        payment.setOrderId("A001");
        payment.setAmount(0L);
        payment.setCreditCard("9");

        checkValidate(payment);
    }

    @Test
    void testPaymentSuccess() {
        Payment payment = new Payment();
        payment.setOrderId("A001");
        payment.setAmount(1_000_000L);
        payment.setCreditCard("4111111111111111");

        checkValidate(payment);
    }
}

package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Payment;
import self.java.validation.groups.PaymentGroup;

public class GroupSequenceTest extends UtilValidationTest{
    @Test
    void testSequence() {
        Payment payment = new Payment();
        payment.setOrderId("A001");
        payment.setAmount(1_000_000L);
        payment.setCreditCard("4111111111111111");

        payment.setVirtualAccount("sample");

        checkValidate(payment, PaymentGroup.class);
    }
}

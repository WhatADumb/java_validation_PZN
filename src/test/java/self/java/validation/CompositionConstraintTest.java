package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Payment;
import self.java.validation.groups.CreditCardPaymentGroup;

public class CompositionConstraintTest extends UtilValidationTest{

    @Test
    void testCompos() {
        Payment payment = new Payment();
        payment.setOrderId("app245134242pp");

        checkValidate(payment, CreditCardPaymentGroup.class);
    }
}

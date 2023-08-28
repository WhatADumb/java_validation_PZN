package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Payment;
import self.java.validation.groups.VirtualAccountPaymentGroup;

public class MessageInterpolationTest extends UtilValidationTest{
    @Test
    void testInterpolation() {
        Payment payment = new Payment();
        payment.setOrderId("a11010101010101010");
        payment.setAmount(0L);
        payment.setVirtualAccount("312315");

        checkValidate(payment, VirtualAccountPaymentGroup.class);
    }
}

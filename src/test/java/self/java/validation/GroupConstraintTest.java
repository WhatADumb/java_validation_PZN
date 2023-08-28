package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Payment;
import self.java.validation.groups.CreditCardPaymentGroup;
import self.java.validation.groups.VirtualAccountPaymentGroup;

public class GroupConstraintTest extends UtilValidationTest{
    @Test
    void testCreditCard() {
        Payment payment = new Payment();
        payment.setOrderId("A001");
        payment.setAmount(1_000_000L);
        payment.setCreditCard("sample");

        checkValidate(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testVirtualAccount() {
        Payment payment = new Payment();
        payment.setOrderId("A001");
        payment.setAmount(1_000_000L);
        payment.setVirtualAccount("");

        checkValidate(payment, VirtualAccountPaymentGroup.class);
    }
}

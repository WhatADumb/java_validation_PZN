package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Payment;
import self.java.validation.groups.CreditCardPaymentGroup;

import java.util.Locale;

public class CustomConstraintTest extends UtilValidationTest{

    @Test
    void testConstraint() {
        Payment payment = new Payment();
        payment.setOrderId("abcde");
        checkValidate(payment, CreditCardPaymentGroup.class);
    }

    @Test
    void testConstraintI18n() {
        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("abcde");
        checkValidate(payment, CreditCardPaymentGroup.class);
    }
}

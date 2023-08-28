package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Customer;
import self.java.validation.data.Payment;
import self.java.validation.groups.VirtualAccountPaymentGroup;

public class GroupConversionTest extends UtilValidationTest{

    @Test
    void testConversionFailed() {
        Payment payment = new Payment();

        payment.setOrderId("A001");
        payment.setAmount(200_000L);
        payment.setVirtualAccount("sample");
        payment.setCustomer(new Customer());

        checkValidate(payment, VirtualAccountPaymentGroup.class);
    }

    @Test
    void testConversionSuccess() {
        Payment payment = new Payment();
        Customer customer = new Customer();

        customer.setEmail("sample@gmail.com");
        customer.setName("sample-name");

        payment.setOrderId("A001");
        payment.setAmount(200_000L);
        payment.setVirtualAccount("sample");
        payment.setCustomer(customer);

        checkValidate(payment, VirtualAccountPaymentGroup.class);
    }
}

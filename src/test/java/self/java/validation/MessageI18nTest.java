package self.java.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.MessageInterpolator;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.hibernate.validator.messageinterpolation.ExpressionLanguageFeatureLevel;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Payment;
import self.java.validation.groups.VirtualAccountPaymentGroup;

import java.util.Locale;
import java.util.Set;

public class MessageI18nTest extends UtilValidationTest{
    @Test
    void testI18n() {
        Locale.setDefault(new Locale("in", "ID"));

        Payment payment = new Payment();
        payment.setOrderId("a11010101010101010");
        payment.setAmount(0L);
        payment.setVirtualAccount("312315");

        checkValidate(payment, VirtualAccountPaymentGroup.class);
    }

    @Test
    void testMessageInterpolator() {
        Locale locale = new Locale("in", "ID");

        Payment payment = new Payment();
        payment.setOrderId("a11010101010101010");
        payment.setAmount(0L);
        payment.setVirtualAccount("312315");

        Set<ConstraintViolation<Object>> violations = validator.validate(payment, VirtualAccountPaymentGroup.class);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Message Template: " + violation.getMessageTemplate());

            MessageInterpolator.Context contextInterpolator = new MessageInterpolatorContext(
                    violation.getConstraintDescriptor(), violation.getInvalidValue(), violation.getRootBeanClass(), violation.getPropertyPath(),
                    violation.getConstraintDescriptor().getAttributes(), violation.getConstraintDescriptor().getAttributes(), ExpressionLanguageFeatureLevel.VARIABLES,
                    true
                    );

            String message = messageInterpolator.interpolate(violation.getMessageTemplate(), contextInterpolator, locale);
            System.out.println(message);
            System.out.println("------------------");
        }
    }
}

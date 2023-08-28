package self.java.validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Person;

public class ConstraintViolationExceptionTest extends UtilValidationTest{
    @Test
    void testException() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            checkValidateException(person);
        });
    }
}

package self.java.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.metadata.ConstraintDescriptor;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Person;

import java.util.Set;

public class ConstraintDescriptorTest extends UtilValidationTest{
    @Test
    void testDesc() {
        Person person = new Person();

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> violation : violations) {
            ConstraintDescriptor<?> descriptor = violation.getConstraintDescriptor();
            System.out.println(descriptor.getAnnotation());
            System.out.println(descriptor.getGroups());
            System.out.println(descriptor.getPayload());
            System.out.println("====================");
        }
    }
}

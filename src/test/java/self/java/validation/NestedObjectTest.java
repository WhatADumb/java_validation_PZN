package self.java.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Address;
import self.java.validation.data.Person;

import java.util.Set;

public class NestedObjectTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    void testNestedObj() {
        Person person = new Person("Fadhil", "Firmansyah", null);
        Address address = new Address();

        person.setAddress(address);

        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getMessage());
            System.out.println(violation.getPropertyPath());
            System.out.println("-------------------------");
        }
    }
}

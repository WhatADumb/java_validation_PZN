package self.java.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Address;
import self.java.validation.data.Person;

import java.lang.reflect.Constructor;
import java.util.Set;

public class ConstructorValidationTest extends UtilValidationTest{
    @Test
    void testConstructorParameterValidation() throws NoSuchMethodException {
        String fName = "";
        String lName = "";
        Address address = null;

        Constructor<Person> constructorPerson = Person.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorParameters(constructorPerson, new Object[]{fName, lName, address});

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    void testConstructorReturnValidation() throws NoSuchMethodException {
        String fName = "";
        String lName = "";
        Address address = null;

        Person person = new Person(fName, lName, address);

        Constructor<Person> constructorPerson = Person.class.getConstructor(String.class, String.class, Address.class);

        Set<ConstraintViolation<Person>> violations = executableValidator.validateConstructorReturnValue(constructorPerson, person);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }
}

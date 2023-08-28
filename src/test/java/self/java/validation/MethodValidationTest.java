package self.java.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Person;

import java.lang.reflect.Method;
import java.util.Set;

public class MethodValidationTest extends UtilValidationTest{
    @Test
    void testMethodVoid() throws NoSuchMethodException {
        Person person = new Person();
        String name = "";
        Method mSayHello = Person.class.getMethod("sayHello", String.class);
        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateParameters(person, mSayHello, new Object[]{name});

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    void testMethodReturnValue() throws NoSuchMethodException {
        Person person = new Person();
        person.setFirstName("");
        person.setLastName("");
        String fullName = person.fullName();

        Method mFullName = Person.class.getMethod("fullName");
        Set<ConstraintViolation<Person>> violations = executableValidator
                .validateReturnValue(person, mFullName, fullName);

        for (ConstraintViolation<Person> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }
}

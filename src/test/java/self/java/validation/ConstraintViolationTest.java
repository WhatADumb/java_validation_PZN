package self.java.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Person;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConstraintViolationTest {
    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    @Test
    void testViolationsFailed1() {
        Person person = new Person();
        Set<ConstraintViolation<Person>> violationSet = validator.validate(person);
        assertEquals(2, violationSet.size());

        for (ConstraintViolation<Person> constraintViolation : violationSet) {
            System.out.println("Message: " + constraintViolation.getMessage());
            System.out.println("Bean: " + constraintViolation.getLeafBean());
            System.out.println("Constraint: " + constraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println("Value: " + constraintViolation.getInvalidValue());
            System.out.println("Path: " + constraintViolation.getPropertyPath());
            System.out.println("------------------");
        }
    }

    @Test
    void testViolationsFailed2() {
        Person person = new Person("LLLLLLLLLLLLLLLLLLLLLLLLLLLL", "LLLLLLLLLLLLLLLLLLLLLLLLLLLL", null);
        Set<ConstraintViolation<Person>> violationSet = validator.validate(person);
        assertEquals(2, violationSet.size());

        for (ConstraintViolation<Person> constraintViolation : violationSet) {
            System.out.println("Message: " + constraintViolation.getMessage());
            System.out.println("Bean: " + constraintViolation.getLeafBean());
            System.out.println("Constraint: " + constraintViolation.getConstraintDescriptor().getAnnotation());
            System.out.println("Value: " + constraintViolation.getInvalidValue());
            System.out.println("Path: " + constraintViolation.getPropertyPath());
            System.out.println("------------------");
        }
    }

    @Test
    void testViolationsSuccess() {
        Person person = new Person("Fadhil", "Firmansyah", null);
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        
        assertEquals(0, violations.size());
        assertNotNull(violations);
    }
}

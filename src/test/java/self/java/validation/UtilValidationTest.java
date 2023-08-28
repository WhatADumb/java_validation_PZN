package self.java.validation;

import jakarta.validation.*;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import self.java.validation.extractor.DataIntegerValueExtractor;
import self.java.validation.extractor.DataValueExtractor;
import self.java.validation.extractor.EntryValueExtractorKey;
import self.java.validation.extractor.EntryValueExtractorValue;

import java.util.Set;

public abstract class UtilValidationTest {
    protected ValidatorFactory validatorFactory;
    protected Validator validator;
    protected ExecutableValidator executableValidator;
    protected MessageInterpolator messageInterpolator;

    @BeforeEach
    void setUp() {
//        validatorFactory = Validation.buildDefaultValidatorFactory();

        validatorFactory = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .addValueExtractor(new EntryValueExtractorKey())
                .addValueExtractor(new EntryValueExtractorValue())
                .addValueExtractor(new DataIntegerValueExtractor())
                .buildValidatorFactory();
        validator = validatorFactory.getValidator();
        messageInterpolator = validatorFactory.getMessageInterpolator();
        executableValidator = validator.forExecutables();
    }

    @AfterEach
    void tearDown() {
        validatorFactory.close();
    }

    void checkValidate(Object obj){
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Constraint: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Value: " + violation.getInvalidValue());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("------------------");
        }
    }

    void checkValidateException(Object obj){
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);

        if(!violations.isEmpty()){
            throw new ConstraintViolationException(violations);
        }
    }

    void checkValidate(Object obj, Class<?>... groups){
        Set<ConstraintViolation<Object>> violations = validator.validate(obj, groups);
        for (ConstraintViolation<Object> violation : violations) {
            System.out.println("Message: " + violation.getMessage());
            System.out.println("Bean: " + violation.getLeafBean());
            System.out.println("Constraint: " + violation.getConstraintDescriptor().getAnnotation());
            System.out.println("Value: " + violation.getInvalidValue());
            System.out.println("Path: " + violation.getPropertyPath());
            System.out.println("------------------");
        }
    }
}

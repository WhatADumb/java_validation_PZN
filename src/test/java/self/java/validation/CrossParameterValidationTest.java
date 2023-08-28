package self.java.validation;

import jakarta.validation.ConstraintViolation;
import org.junit.jupiter.api.Test;
import self.java.validation.service.UserService;

import java.lang.reflect.Method;
import java.util.Set;

public class CrossParameterValidationTest extends UtilValidationTest {

    @Test
    void testCrossParameter() throws NoSuchMethodException {
        UserService userService = new UserService();

        Method methodRegister = UserService.class.getMethod("register", String.class, String.class, String.class);

        String username = "fadhil";
        String password = "sample";
        String retypePassword = "sample321";

        Set<ConstraintViolation<UserService>> violations = executableValidator.validateParameters(userService, methodRegister, new Object[]{
                username, password, retypePassword
        });

        for (ConstraintViolation<UserService> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
            System.out.println("-----------------------------");
        }
    }
}

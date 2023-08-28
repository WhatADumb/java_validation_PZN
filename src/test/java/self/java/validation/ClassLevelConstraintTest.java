package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Register;

public class ClassLevelConstraintTest extends UtilValidationTest{

    @Test
    void testClassLevel() {
        Register register = new Register();
        register.setUsername("Data-1");
        register.setPassword("abcde");
        register.setRetypePassword("abcde1234");

        checkValidate(register);
    }
}

package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.LoginRequest;

public class RecordTest {
    @Test
    void testRecord() {
        LoginRequest loginRequest1 = new LoginRequest();
        System.out.println(loginRequest1);

        LoginRequest loginRequest2 = new LoginRequest("panju");
        System.out.println(loginRequest2);

        LoginRequest loginRequest3 = new LoginRequest("dhil", "123");
        System.out.println(loginRequest3);
        System.out.println("Username: " + loginRequest3.username());
        System.out.println("Password: " + loginRequest3.password());
    }
}

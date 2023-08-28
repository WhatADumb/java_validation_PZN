package self.java.validation.service;

import jakarta.validation.constraints.NotBlank;
import self.java.validation.constraints.CheckPasswordParameter;

public class UserService {
    @CheckPasswordParameter(passwordParam = 1, retypePasswordParam = 2)
    public void register(@NotBlank(message = "Username can't empty") String username,
                         @NotBlank(message = "Password can't empty") String password,
                         @NotBlank(message = "Retype Password can't empty") String retypePassword){

    }
}

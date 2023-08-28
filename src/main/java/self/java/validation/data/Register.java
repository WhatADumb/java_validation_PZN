package self.java.validation.data;

import jakarta.validation.constraints.NotBlank;
import self.java.validation.constraints.CheckPassword;

@CheckPassword(message = "Password and Retype Password must be same")
public class Register {
    @NotBlank(message = "Username can't be empty")
    private String username;

    @NotBlank(message = "Password can't be empty")
    private String password;

    @NotBlank(message = "Retype Password can't be empty")
    private String retypePassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetypePassword() {
        return retypePassword;
    }

    public void setRetypePassword(String retypePassword) {
        this.retypePassword = retypePassword;
    }

    public Register(String username, String password, String retypePassword) {
        this.username = username;
        this.password = password;
        this.retypePassword = retypePassword;
    }

    public Register() {
    }

    @Override
    public String toString() {
        return "Register{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", retypePassword='" + retypePassword + '\'' +
                '}';
    }
}

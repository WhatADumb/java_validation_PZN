package self.java.validation.data;

import jakarta.validation.constraints.NotBlank;

public class Address {
    @NotBlank(message = "Field street must be fill")
    private String street;

    @NotBlank(message = "Field city must be fill")
    private String city;

    @NotBlank(message = "Field country must be fill")
    private String country;
}

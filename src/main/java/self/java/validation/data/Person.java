package self.java.validation.data;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Person {

    private List<@NotBlank(message = "Hobby can't blank") String> hobbies;

    @NotBlank(message = "First Name must be filled")
    @Size(max = 20, message = "First Name must 20 characters")
    private String firstName;

    @NotBlank(message = "Last Name must be filled")
    @Size(max = 20, message = "Last Name must 20 characters")
    private String lastName;

    @NotNull(message = "Address can't be null")
    @Valid
    private Address address;

    @Valid
    public Person() {
    }

    @Valid
    public Person(@NotBlank(message = "First Name can't empty")String firstName,
                  @NotBlank(message = "Last Name can't empty")String lastName,
                  @NotNull(message = "Address can't empty") @Valid Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void sayHello(@NotBlank(message = "Name can't empty")String name){
        System.out.println("Hello " + name + ", My name is " + this.firstName);
    }

    @NotBlank(message = "All names must be filled")
    public String fullName(){
        return this.firstName + " " + this.lastName;
    }
}

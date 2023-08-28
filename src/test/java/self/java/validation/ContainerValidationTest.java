package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.data.Person;

import java.util.ArrayList;

public class ContainerValidationTest extends UtilValidationTest{

    @Test
    void testContainerData() {
        Person person = new Person();

        person.setHobbies(new ArrayList<>());
        person.getHobbies().add("");
        person.getHobbies().add(" ");
        person.getHobbies().add("Study");

        checkValidate(person);
    }
}

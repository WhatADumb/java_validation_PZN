package self.java.validation;

import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.junit.jupiter.api.Test;
import self.java.validation.data.Person;

public class MetadataTest extends UtilValidationTest{
    @Test
    void testBean() {
        BeanDescriptor bean = validator.getConstraintsForClass(Person.class);

        for (PropertyDescriptor property : bean.getConstrainedProperties()) {
            System.out.println(property.getPropertyName());
            for (ConstraintDescriptor<?> descriptor : property.getConstraintDescriptors()) {
                System.out.println(descriptor);
            }
        }
    }
}

package self.java.validation;

import org.junit.jupiter.api.Test;
import self.java.validation.container.Data;
import self.java.validation.container.DataInteger;
import self.java.validation.container.Entry;
import self.java.validation.data.SampleData;
import self.java.validation.data.SampleDataInteger;
import self.java.validation.data.SampleEntry;

public class ValueExtractorTest extends UtilValidationTest{
    @Test
    void testSingle() {
        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());
        sampleData.getData().setVals("  ");

        checkValidate(sampleData);
    }

    @Test
    void testMultiple() {
        SampleEntry entry = new SampleEntry();
        entry.setEntry(new Entry<>());
        entry.getEntry().setKey(" ");
        entry.getEntry().setValue(" ");

        checkValidate(entry);
    }

    @Test
    void testNonGeneric() {
        SampleDataInteger dataInteger = new SampleDataInteger();
        dataInteger.setDataInteger(new DataInteger());
        dataInteger.getDataInteger().setDataInt(7);

        checkValidate(dataInteger);
    }
}

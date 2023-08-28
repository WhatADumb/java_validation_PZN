package self.java.validation.data;

import jakarta.validation.constraints.Min;
import self.java.validation.container.DataInteger;

public class SampleDataInteger {
    @Min(value = 10)
    private DataInteger dataInteger;

    public DataInteger getDataInteger() {
        return dataInteger;
    }

    public void setDataInteger(DataInteger dataInteger) {
        this.dataInteger = dataInteger;
    }
}

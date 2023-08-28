package self.java.validation.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import self.java.validation.container.Data;

public class SampleData {
    private Data<@NotBlank @Size(min = 10) String> data;

    public Data<String> getData() {
        return data;
    }

    public void setData(Data<String> data) {
        this.data = data;
    }
}

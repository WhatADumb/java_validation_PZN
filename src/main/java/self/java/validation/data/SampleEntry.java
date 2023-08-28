package self.java.validation.data;

import jakarta.validation.constraints.NotBlank;
import self.java.validation.container.Entry;

public class SampleEntry {
    private Entry<@NotBlank String, @NotBlank String> entry;

    public Entry<String, String> getEntry() {
        return entry;
    }

    public void setEntry(Entry<String, String> entry) {
        this.entry = entry;
    }
}

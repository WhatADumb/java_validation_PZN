package self.java.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import self.java.validation.container.Entry;

public class EntryValueExtractorValue implements ValueExtractor<Entry<?,@ExtractedValue ?>> {
    @Override
    public void extractValues(Entry<?, ?> entry, ValueReceiver valueReceiver) {
        valueReceiver.keyedValue(null, "Value", entry.getValue());
    }
}

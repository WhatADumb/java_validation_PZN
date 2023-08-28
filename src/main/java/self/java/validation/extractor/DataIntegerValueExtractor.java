package self.java.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.UnwrapByDefault;
import jakarta.validation.valueextraction.ValueExtractor;
import self.java.validation.container.DataInteger;

@UnwrapByDefault
public class DataIntegerValueExtractor implements ValueExtractor<@ExtractedValue(type = Integer.class) DataInteger> {
    @Override
    public void extractValues(DataInteger dataInteger, ValueReceiver valueReceiver) {
        valueReceiver.value(null, dataInteger.getDataInt());
    }
}

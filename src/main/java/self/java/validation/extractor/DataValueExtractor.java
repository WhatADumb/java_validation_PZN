package self.java.validation.extractor;

import jakarta.validation.valueextraction.ExtractedValue;
import jakarta.validation.valueextraction.ValueExtractor;
import self.java.validation.container.Data;

public class DataValueExtractor implements ValueExtractor<Data<@ExtractedValue ?>> {

    @Override
    public void extractValues(Data<?> data, ValueReceiver valueReceiver) {
        valueReceiver.value(null, data.getVals());
    }
}

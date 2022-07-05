package com.autoscanner.model.converter;

import com.autoscanner.model.autoscanner.EngineType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class EngineTypeConverter implements AttributeConverter<EngineType, String> {

    @Override
    public String convertToDatabaseColumn(final EngineType engineType) {
        if (engineType == null){
            return null;
        }
        return engineType.getEngineType();
    }

    @Override
    public EngineType convertToEntityAttribute(final String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(EngineType.values())
                .filter(engineType ->  Objects.equals(engineType.getEngineType(), dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

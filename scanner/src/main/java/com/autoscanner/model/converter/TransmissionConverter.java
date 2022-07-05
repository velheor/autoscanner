package com.autoscanner.model.converter;

import com.autoscanner.model.autoscanner.Transmission;

import javax.persistence.AttributeConverter;
import java.util.Objects;
import java.util.stream.Stream;

public class TransmissionConverter implements AttributeConverter<Transmission, String> {
    @Override
    public String convertToDatabaseColumn(final Transmission transmission) {
        if (transmission == null) {
            return null;
        }
        return transmission.getTransmission();
    }

    @Override
    public Transmission convertToEntityAttribute(final String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(Transmission.values())
                .filter(transmission -> Objects.equals(transmission.getTransmission(), dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

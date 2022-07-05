package com.autoscanner.model.converter;

import com.autoscanner.model.autoscanner.VehicleType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class VehicleTypeConverter implements AttributeConverter<VehicleType, String> {

    @Override
    public String convertToDatabaseColumn(final VehicleType vehicleType) {
        if (vehicleType == null) {
            return null;
        }
        return vehicleType.getVehicleType();
    }

    @Override
    public VehicleType convertToEntityAttribute(final String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(VehicleType.values())
                .filter(vehicleType -> Objects.equals(vehicleType.getVehicleType(), dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}

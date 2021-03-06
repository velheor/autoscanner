package com.autoscanner.service.vehicle;

import com.autoscanner.dto.VehicleParameterDto;
import com.autoscanner.model.autoscanner.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllByMakeId(final Long makeId);
    List<Vehicle> getAllByModelId(final Long modelId);
    List<Vehicle> getAllByParameters(final VehicleParameterDto vehicleParameterDto);
}

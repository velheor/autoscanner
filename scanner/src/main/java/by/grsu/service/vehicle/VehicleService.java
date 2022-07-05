package by.grsu.service.vehicle;

import by.grsu.dto.VehicleParameterDto;
import by.grsu.model.autoscanner.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAllByMakeId(final Long makeId);
    List<Vehicle> getAllByModelId(final Long modelId);
    List<Vehicle> getAllByParameters(final VehicleParameterDto vehicleParameterDto);
}

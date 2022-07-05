package by.grsu.service.vehicle.impl;

import by.grsu.dto.VehicleParameterDto;
import by.grsu.model.autoscanner.Vehicle;
import by.grsu.repository.VehicleRepository;
import by.grsu.service.vehicle.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {
    private final VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> getAllByMakeId(final Long makeId) {
        return vehicleRepository.findAllByMakeId(makeId).stream().limit(10).collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> getAllByModelId(final Long modelId) {
        return vehicleRepository.findAllByModelId(modelId);
    }

    @Override
    public List<Vehicle> getAllByParameters(final VehicleParameterDto vehicleParameterDto) {
        return vehicleRepository.findByParams(vehicleParameterDto.getMakeId(),
                vehicleParameterDto.getModelId(),
                vehicleParameterDto.getFromPrice(),
                vehicleParameterDto.getToPrice(),
                vehicleParameterDto.getFromYear(),
                vehicleParameterDto.getToYear());
    }
}

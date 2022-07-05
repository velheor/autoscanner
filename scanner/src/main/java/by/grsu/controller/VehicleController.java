package by.grsu.controller;

import by.grsu.dto.VehicleParameterDto;
import by.grsu.model.autoscanner.Vehicle;
import by.grsu.service.vehicle.VehicleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/vehicle")
@RestController
@CrossOrigin
public class VehicleController {
    private final VehicleService vehicleService;

    @PostMapping("params")
    public List<Vehicle> getByParameters(@RequestBody VehicleParameterDto vehicleParameterDto) {
        log.info("'api/vehicle/params' method was called with vehicleParameterDto = {}", vehicleParameterDto);
        return vehicleService.getAllByParameters(vehicleParameterDto);
    }

    @GetMapping("make/{makeId}")
    public List<Vehicle> getByMakeId(@PathVariable Long makeId) {
        log.info("'api/vehicle/make/{makeId}' method was called with makeId = {}", makeId);
        return vehicleService.getAllByMakeId(makeId);
    }

    @GetMapping("model/{modelId}")
    public List<Vehicle> getByModelId(@PathVariable Long modelId) {
        log.info("'api/vehicle/model/{modelId}' method was called with modelId = {}", modelId);
        return vehicleService.getAllByModelId(modelId);
    }
}

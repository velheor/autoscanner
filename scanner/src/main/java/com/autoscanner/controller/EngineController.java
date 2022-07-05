package com.autoscanner.controller;

import com.autoscanner.model.autoscanner.EngineCapacity;
import com.autoscanner.model.autoscanner.EngineType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("api/engine")
@Slf4j
@RestController
@CrossOrigin
public class EngineController {

    @GetMapping("types")
    public Set<String> getEngineTypes() {
         return Arrays.stream(EngineType.values())
                 .map(EngineType::getEngineType)
                 .collect(Collectors.toSet());
    }

    @GetMapping("capacity")
    public Set<String> getEngineCapacities() {
        return EngineCapacity.CAPACITY;
    }
}

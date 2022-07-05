package com.autoscanner.controller;

import com.autoscanner.model.autoscanner.Transmission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("api/transmission")
@Slf4j
@RestController
@CrossOrigin
public class TransmissionController {

    @GetMapping("types")
    public Set<String> getEngineTypes() {
        return Arrays.stream(Transmission.values())
                .map(Transmission::getTransmission)
                .collect(Collectors.toSet());
    }
}

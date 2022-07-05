package com.autoscanner.service.scan.avby;

import com.autoscanner.model.autoscanner.Make;
import com.autoscanner.model.autoscanner.Model;
import com.autoscanner.repository.MakeRepository;
import com.autoscanner.repository.ModelRepository;
import com.autoscanner.service.scan.avby.make.MakeAvByProcess;
import com.autoscanner.service.scan.avby.model.ModelAvByProcess;
import com.autoscanner.service.scan.avby.vehicle.VehicleAvByScanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import static java.lang.String.valueOf;

@Slf4j
@Service
@RequiredArgsConstructor
public class ScannerAvBy {
    private final MakeAvByProcess makeAvByProcess;
    private final ModelAvByProcess modelAvByProcess;
    private final MakeRepository makeRepository;
    private final ModelRepository modelRepository;
    private final VehicleAvByScanService vehicleAvByScanService;

    @Value("${scan.when.start::0}")
    private boolean scanWhenStart;

    @PostConstruct
    public void scanFirst() {
        if (!scanWhenStart) {
            return;
        }
        try {
            Set<Make> listOfMakes;
            listOfMakes = makeProcessing();
            final Set<Model> modelAvBIES = modelProcessing(listOfMakes);
            vehicleProcessing(modelAvBIES);
        } catch (Exception exception) {
            log.error(valueOf(exception));
        }
    }

    private void vehicleProcessing(final Set<Model> modelAvBIES) {
        vehicleAvByScanService.scanVehicles(modelAvBIES);
    }

    private Set<Make> makeProcessing() throws IOException {
        Set<Make> listOfMakes;
        if (makeRepository.count() == 0) {
            listOfMakes = makeAvByProcess.getListOfMakes();
            listOfMakes = new TreeSet<>(makeRepository.saveAll(new TreeSet<>(listOfMakes)));
        } else {
            listOfMakes = new TreeSet<>(makeRepository.findAll());
        }
        return listOfMakes;
    }

    private Set<Model> modelProcessing(final Set<Make> listOfMakes) {
        if (modelRepository.count() > 0) {
            return new HashSet<>(modelRepository.findAll());
        }
        final Set<Model> models = new TreeSet<>();
        listOfMakes.parallelStream().forEach(makeAvBy -> {
            try {
                models.addAll(modelAvByProcess.getListOfModels(makeAvBy));
                makeAvBy.setModels(modelAvByProcess.getListOfModels(makeAvBy));
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.debug(makeAvBy.toString());
        });
        return new HashSet<>(modelRepository.saveAll(models));
    }

}

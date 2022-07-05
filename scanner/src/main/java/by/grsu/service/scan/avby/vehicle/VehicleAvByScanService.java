package by.grsu.service.scan.avby.vehicle;

import by.grsu.model.autoscanner.Model;

import java.util.Set;

public interface VehicleAvByScanService {
    void scanVehicles(final Set<Model> modelAvBIES);
}

package com.autoscanner.service.scan.avby.vehicle;

import com.autoscanner.model.autoscanner.Model;

import java.util.Set;

public interface VehicleAvByScanService {
    void scanVehicles(final Set<Model> modelAvBIES);
}

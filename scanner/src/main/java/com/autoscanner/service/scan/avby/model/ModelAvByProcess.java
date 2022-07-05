package com.autoscanner.service.scan.avby.model;

import com.autoscanner.model.autoscanner.Make;
import com.autoscanner.model.autoscanner.Model;

import java.io.IOException;
import java.util.Set;

public interface ModelAvByProcess {
    Set<Model> getListOfModels(Make make) throws IOException;
}

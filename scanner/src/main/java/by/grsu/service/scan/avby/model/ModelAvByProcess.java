package by.grsu.service.scan.avby.model;

import by.grsu.model.autoscanner.Make;
import by.grsu.model.autoscanner.Model;

import java.io.IOException;
import java.util.Set;

public interface ModelAvByProcess {
    Set<Model> getListOfModels(Make make) throws IOException;
}

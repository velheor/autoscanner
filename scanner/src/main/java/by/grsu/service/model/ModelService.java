package by.grsu.service.model;

import by.grsu.model.autoscanner.Model;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface ModelService {
    List<Model> saveAll(Set<Model> models);

    List<Model> getAll();

    Model getById(Long id);

    List<Model> getModelsByMakeId(Long makeId);
}

package com.autoscanner.service.model;

import com.autoscanner.model.autoscanner.Model;

import java.util.List;
import java.util.Set;

public interface ModelService {
    List<Model> saveAll(Set<Model> models);

    List<Model> getAll();

    Model getById(Long id);

    List<Model> getModelsByMakeId(Long makeId);
}

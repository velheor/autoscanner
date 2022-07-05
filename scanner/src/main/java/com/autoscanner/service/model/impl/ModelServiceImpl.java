package com.autoscanner.service.model.impl;

import com.autoscanner.model.autoscanner.Model;
import com.autoscanner.repository.ModelRepository;
import com.autoscanner.service.model.ModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class ModelServiceImpl implements ModelService {
    private final ModelRepository modelRepository;

    @Override
    public List<Model> saveAll(final Set<Model> models) {
        return null;

//        return modelRepository.saveAll(models);
    }

    @Override
    public List<Model> getAll() {
        return null;

//        return modelRepository.findAll();
    }

    @Override
    public Model getById(final Long id) {
        return modelRepository.getById(id);
    }

    @Override
    public List<Model> getModelsByMakeId(final Long makeId) {
        return modelRepository.findAllByMakeId(makeId);
    }
}

package com.autoscanner.service.brand.impl;

import com.autoscanner.model.autoscanner.Make;
import com.autoscanner.repository.MakeRepository;
import com.autoscanner.service.brand.MakeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Slf4j
@RequiredArgsConstructor
@Service
public class MakeServiceImpl implements MakeService {
    private final MakeRepository makeRepository;

    @Override
    public List<Make> saveAll(final Set<Make> makes) {
        return makeRepository.saveAll(makes);
    }

    @Override
    public List<Make> getAll() {
        return makeRepository.findAll();
    }

    @Override
    public Make getById(final Long id) {
        return makeRepository.getById(id);
    }

}

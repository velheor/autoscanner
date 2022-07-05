package com.autoscanner.service.brand;


import com.autoscanner.model.autoscanner.Make;

import java.util.List;
import java.util.Set;

public interface MakeService {
    List<Make> saveAll(Set<Make> makes);

    List<Make> getAll();

    Make getById(Long id);
}

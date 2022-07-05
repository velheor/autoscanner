package by.grsu.service.brand;


import by.grsu.model.autoscanner.Make;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface MakeService {
    List<Make> saveAll(Set<Make> makes);

    List<Make> getAll();

    Make getById(Long id);
}

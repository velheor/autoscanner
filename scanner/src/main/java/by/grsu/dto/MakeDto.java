package by.grsu.dto;

import by.grsu.model.autoscanner.Make;
import lombok.Data;

import java.util.Set;
import java.util.stream.Collectors;

@Data
public class MakeDto {
    private Long id;
    private String name;
    private Set<ModelDto> models;

    public MakeDto(Make make) {
        this.id = make.getId();
        this.name = make.getName();
        this.models = make.getModels()
                .stream()
                .map(ModelDto::new)
                .collect(Collectors.toSet());
    }
}

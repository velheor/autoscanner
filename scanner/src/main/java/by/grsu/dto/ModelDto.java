package by.grsu.dto;

import by.grsu.model.autoscanner.Model;
import lombok.Data;

@Data
public class ModelDto {
    private Long id;
    private String name;

    public ModelDto(Model name) {
        this.id = name.getId();
        this.name = name.getName();
    }
}

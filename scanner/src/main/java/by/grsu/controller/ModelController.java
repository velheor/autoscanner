package by.grsu.controller;

import by.grsu.dto.ModelDto;
import by.grsu.service.model.ModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RequestMapping("api/models")
@RestController
@CrossOrigin
public class ModelController {
    private final ModelService modelService;

    @GetMapping("{makeId}")
    public List<ModelDto> getModels(@PathVariable Long makeId) {
        return modelService.getModelsByMakeId(makeId)
                .stream()
                .map(ModelDto::new)
                .collect(Collectors.toList());
    }
}

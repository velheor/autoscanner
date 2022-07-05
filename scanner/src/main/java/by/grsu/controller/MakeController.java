package by.grsu.controller;

import by.grsu.dto.MakeDto;
import by.grsu.service.brand.MakeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("api/makes")
@CrossOrigin
public class MakeController {
    private final MakeService makeService;

    @GetMapping
    public List<MakeDto> getMakes() {
        return makeService.getAll()
                .stream()
                .map(MakeDto::new)
                .collect(Collectors.toList());
    }
}

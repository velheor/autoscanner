//package by.grsu.controller;
//
//import by.grsu.dto.CarDto;
//import by.grsu.dto.CarParameterDto;
//import by.grsu.service.car.CarService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("api/cars")
//@Slf4j
//@RequiredArgsConstructor
//@CrossOrigin
//public class CarsController {
//    private final CarService carService;
//
//    @PostMapping("find")
//    public List<CarDto> findCarByParameters(@RequestBody CarParameterDto carParameterDto) {
//        return carService.getCarsByParameters(carParameterDto)
//                .stream()
//                .map(CarDto::new)
//                .collect(Collectors.toList());
//    }
//}

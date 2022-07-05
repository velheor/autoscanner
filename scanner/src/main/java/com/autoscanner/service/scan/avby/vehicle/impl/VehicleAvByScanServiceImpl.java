package com.autoscanner.service.scan.avby.vehicle.impl;

import com.autoscanner.model.autoscanner.*;
import com.autoscanner.repository.VehicleRepository;
import com.autoscanner.service.scan.avby.vehicle.VehicleAvByScanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import static com.autoscanner.utils.LinksBuilder.buildLink;
import static javax.transaction.Transactional.TxType.REQUIRED;

@Slf4j
@Service
@RequiredArgsConstructor
public class VehicleAvByScanServiceImpl implements VehicleAvByScanService {
    private final VehicleRepository vehicleRepository;
    final static Map<String, VehicleType> types = new HashMap<>();

    static {
        types.put("внедорожник", VehicleType.SUV);
        types.put("кабриолет", VehicleType.CABRIOLET);
        types.put("купе", VehicleType.COUPE);
        types.put("другой", VehicleType.ANOTHER);
        types.put("хэтчбек", VehicleType.HATCHBACK);
        types.put("универсал", VehicleType.WAGON);
        types.put("седан", VehicleType.SEDAN);
        types.put("пикап", VehicleType.PICKUP);
        types.put("минивэн", VehicleType.MINIVAN);
        types.put("микроавтобус", VehicleType.MINIBUS);
        types.put("лифтбек", VehicleType.LIFTBACK);
        types.put("лимузин", VehicleType.LIMOUSINE);
        types.put("фургон", VehicleType.VAN);
    }

    @Override
//    @Transactional(value = REQUIRED)
    public void scanVehicles(final Set<Model> modelAvBIES) {
        final Map<Make, List<Model>> makesByModels =
                modelAvBIES.stream()
                        .collect(Collectors.groupingBy(Model::getMake));
        for (final Map.Entry<Make, List<Model>> entry : makesByModels.entrySet()) {
            final Set<Vehicle> vehicleSet = new HashSet<>();
            for (final Model model : entry.getValue()) {
                vehicleSet.addAll(getVehicles(entry.getKey(), model));
            }
            vehicleRepository.saveAllAndFlush(vehicleSet);
        }
    }

    private Set<Vehicle> getVehicles(final Make make, final Model model) {
        try {
            Document doc = Jsoup.connect(model.getLink()).get();
            Elements body = doc.getElementsByClass("listing__items");
            final Elements cars = body.select("div.listing-item");
            return cars.stream()
                    .map(element -> buildVehicle(element, make, model))
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            return new HashSet<>();
        }
    }

    private Vehicle buildVehicle(final Element element, final Make make, final Model model) {
        final String carLink = getCarLink(element);
        final String imageLink = getImageLink(element);
        final Integer carPrice = getCarPrice(element);
        final Elements divsWithData = getDivsWithData(element);
        final Short carYear = getCarYear(divsWithData);
        final Integer mileage = getMileage(divsWithData);
        final String location = getLocation(element);
        final String[] arrayWithVehicleInfo = getArrayWithVehicleInfo(divsWithData);
        final Transmission transmission = getTransmission(arrayWithVehicleInfo);
        final String engineCapacity = getEngineCapacity(arrayWithVehicleInfo);
        final EngineType engineType = getEngineType(arrayWithVehicleInfo);
        final VehicleType vehicleType = getVehicleType(arrayWithVehicleInfo);
        return Vehicle.builder()
                .make(make)
                .model(model)
                .link(carLink)
                .imageLink(imageLink)
                .price(BigDecimal.valueOf(carPrice))
                .year(carYear)
                .mileage(String.valueOf(mileage))
                .location(location)
                .transmission(transmission)
                .engineCapacity(engineCapacity)
                .engineType(engineType)
                .vehicleType(vehicleType)
                .build();
    }

    private VehicleType getVehicleType(final String[] arrayWithVehicleInfo) {
        final String s1 = arrayWithVehicleInfo[3].strip();
        if (types.containsKey(s1)) {
            return types.get(s1);
        }
        final String s2 = arrayWithVehicleInfo[2].strip();
        if (types.containsKey(s2)) {
            return types.get(s2);
        }
        return VehicleType.ANOTHER;
    }

    private EngineType getEngineType(final String[] arrayWithVehicleInfo) {
        final String s2 = arrayWithVehicleInfo[2].strip();
        if (s2.contains("бензин")) {
            return EngineType.PETROL;
        }
        if (s2.contains("дизель")) {
            return EngineType.DIESEL;
        }
        final String s = arrayWithVehicleInfo[1];
        if (s.contains("электро")) {
            return EngineType.ELECTRO;
        }
        return EngineType.ANOTHER;
    }

    private String getEngineCapacity(final String[] arrayWithVehicleInfo) {
        final String s = arrayWithVehicleInfo[1].strip();
        if (s.contains("электро")) {
            return "";
        }
        return s.replace("л", "");
    }

    private Transmission getTransmission(final String[] arrayWithVehicleInfo) {
        if (arrayWithVehicleInfo[0].strip().contains("автомат")) {
            return Transmission.AUTOMATIC;
        }
        return Transmission.MANUAL;
    }

    private Integer getMileage(final Elements divsWithData) {
        return Integer.valueOf(divsWithData.get(3).html().replaceAll("\\D+", ""));
    }

    private String[] getArrayWithVehicleInfo(final Elements divsWithData) {
        return divsWithData.get(2).html()
                .replaceAll("<!-- -->", "")
                .replaceAll("&nbsp;", "")
                .split(",");
    }

    private Short getCarYear(final Elements divsWithData) {
        return Short.valueOf(divsWithData.get(1).html().replaceAll("\\D+", ""));
    }

    private Elements getDivsWithData(final Element element) {
        return element.getElementsByClass("listing-item__params").select("div");
    }

    private String getCarLink(final Element element) {
        final String href = element
                .select("div.listing-item__about")
                .select("a.listing-item__link")
                .attr("href");
        return buildLink(href);
    }

    private String getImageLink(final Element element) {
        return element.getElementsByClass("listing-item__photo")
                .select("img")
                .attr("data-src");
    }

    private Integer getInfo(final Element element) {
        final Elements divs = element.getElementsByClass("listing-item__params").select("div");
        return Integer.valueOf(divs.get(2).html().replaceAll("\\D+", ""));
    }

    private String getLocation(final Element element) {
        return element.getElementsByClass("listing-item__info").select("div").get(1).html();
    }

    private Integer getCarPrice(final Element element) {
        final Elements divs = element.getElementsByClass("listing-item__prices").select("div[class=listing-item__priceusd]");
        return Integer.valueOf(Objects.requireNonNull(divs.first()).getElementsByClass("listing-item__priceusd").text().replaceAll("\\D+", ""));
    }

}

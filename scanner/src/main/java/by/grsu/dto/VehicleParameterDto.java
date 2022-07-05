package by.grsu.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class VehicleParameterDto {
    private Long makeId;
    private Long modelId;
    private Short fromYear;
    private Short toYear;
    private BigDecimal fromPrice;
    private BigDecimal toPrice;
}

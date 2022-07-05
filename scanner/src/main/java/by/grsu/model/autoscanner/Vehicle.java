package by.grsu.model.autoscanner;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "autoscanner")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
    private VehicleType vehicleType;
    private EngineType engineType;
    private Transmission transmission;
    @Column
    private String engineCapacity;
    @Column
    private Short year;
    @Column
    private BigDecimal price;
    @Column(unique = true)
    private String link;
    @Column
    private String imageLink;
    @Column
    private String mileage;
    @Column
    private String location;

}

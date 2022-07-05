package by.grsu.model.autoscanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "autoscanner")
public class Model implements Comparable<Model> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("label")
    @SerializedName("label")
    @Column(nullable = false, unique = true)
    private String name;
    @JsonProperty("url")
    @SerializedName("url")
    @Column(nullable = false, unique = true)
    private String link;
    @ManyToOne
    @JoinColumn(name = "make_id")
    private Make make;

    public Model(final String name, final String link) {
        this.name = name;
        this.link = link;
    }

    public Model(final String modelName, final String modelLink, final Make make) {
        this.name = modelName;
        this.link = modelLink;
        this.make = make;
    }

    @Override
    public int compareTo(final Model o) {
        return name.compareTo(o.getName());
    }
}

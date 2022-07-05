package by.grsu.model.autoscanner;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "autoscanner")
public class Make implements Comparable<Make> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true, updatable = false)
    public Long id;
    @JsonProperty("label")
    @SerializedName("label")
    @Column(nullable = false, unique = true, updatable = false)
    public String name;
    @JsonProperty("url")
    @SerializedName("url")
    @Column(nullable = false, unique = true, updatable = false)
    public String link;
    @JsonIgnore
    @OneToMany(mappedBy = "make", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Model> models;

    @Override
    public int compareTo(final Make o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "Make{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}

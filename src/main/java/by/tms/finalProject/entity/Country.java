package by.tms.finalProject.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "spr_country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_country")
    private Integer id;

    @Column(name = "nameCountry")
    @NotEmpty(message = "Введите название страны")
    private String nameCountry;

    @Column(name = "shortName")
    @NotEmpty(message = "Введите краткое название страны")
    private String shortName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<City> cities;
}

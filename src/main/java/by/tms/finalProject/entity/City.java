package by.tms.finalProject.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "spr_city")
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nameCity")
    @NotEmpty(message = "Введите название города")
    private String nameCity;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;
}

package by.tms.finalProject.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "spr_place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "seat")
    @NotNull(message = "Введите номер места")
    private Integer seat;

    @OneToOne
    private PlaceClass placeClass;
}

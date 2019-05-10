package by.tms.finalProject.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.crypto.Mac;
import javax.persistence.*;

@Data
@Entity
@Table(name = "spr_place_class")
public class PlaceClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Введите класс места")
    private String name;
}

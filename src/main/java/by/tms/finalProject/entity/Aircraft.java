package by.tms.finalProject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "spr_aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Введите название самолета")
    private String nameAircraft;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Place> placeList;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(cascade = CascadeType.ALL)
    private Flight flight;
}

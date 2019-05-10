package by.tms.finalProject.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "flightDate")
    private Date flightDate;

    @ManyToOne
    private City cityFrom;

    @ManyToOne
    private City cityTo;

    @OneToOne
    private Aircraft aircraft;
}

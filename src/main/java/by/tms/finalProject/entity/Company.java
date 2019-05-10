package by.tms.finalProject.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "spr_company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    @NotEmpty(message = "Введите название компании")
    private String nameCompany;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Aircraft> owner;
}

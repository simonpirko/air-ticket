package by.tms.finalProject.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Data
@Entity
@Table(name = "passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "login")
    @NotEmpty(message = "Введите логин")
    private String login;

    @Column(name = "password")
    @NotEmpty(message = "Введите пароль")
    private String password;

    @Column(name = "documentNumber")
    private String documentNumber;
}

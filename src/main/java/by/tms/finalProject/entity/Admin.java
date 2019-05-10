package by.tms.finalProject.entity;

import by.tms.finalProject.constant.Role;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Data
@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login", unique = true)
    @NotEmpty(message = "Введите логин")
    private String login;

    @Column(name = "password")
    @NotEmpty(message = "Введите пароль")
    private String password;
}

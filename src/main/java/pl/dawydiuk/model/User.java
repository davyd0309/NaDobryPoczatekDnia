package pl.dawydiuk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.dawydiuk.enums.EPlec;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by Konrad on 13.09.2016.
 */
@Entity
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "login")
    @Getter
    @Setter
    private String login;


    @Column(name = "email")
    @Getter
    @Setter
    private String emial;


    @Column(name = "password")
    @Getter
    @Setter
    private String password;

    @Column(name = "plec")
    @Getter
    @Setter
    private EPlec plec;


}

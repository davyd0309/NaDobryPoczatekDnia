package pl.dawydiuk.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.dawydiuk.enums.EPlec;

import javax.annotation.Generated;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
    @NotNull
    private String login;


    @Column(name = "email")
    @Getter
    @Setter
    @NotNull
    private String email;


    @Column(name = "password")
    @Getter
    @Setter
    @NotNull
    private String password;

    @Column(name = "plec")
    @Getter
    @Setter
    @NotNull
    private EPlec plec;

    @Column(name = "enabled")
    @Getter
    @Setter
    @NotNull
    private boolean enabled = true;

    @Column(name = "credentialexpired")
    @Getter
    @Setter
    @NotNull
    private boolean credentialexpired = false;


    @Column(name = "expired")
    @Getter
    @Setter
    @NotNull
    private boolean expired = false;


    @Column(name = "locked")
    @Getter
    @Setter
    @NotNull
    private boolean locked = false;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "UserRole",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "id"))
    @Getter
    @Setter
    private Set<Role> roles = new HashSet<>();
}

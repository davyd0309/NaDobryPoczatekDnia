package pl.dawydiuk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Konrad on 13.09.2016.
 */

@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;


    @Column(name = "login")
    @Getter
    @Setter
    private Integer login;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    @Getter
    @Setter
    private User user;


    @ManyToOne
    @JoinColumn(name = "jokeId",referencedColumnName = "id")
    @Getter
    @Setter
    private Joke joke;
}

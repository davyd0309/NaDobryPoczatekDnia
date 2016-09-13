package pl.dawydiuk.model;

import lombok.Getter;
import lombok.Setter;
import pl.dawydiuk.enums.ECategory;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Konrad on 13.09.2016.
 */

@Entity
@Table(name = "joke")
public class Joke {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;


    @Column(name = "title")
    @Getter
    @Setter
    private String title;


    @Column(name = "content")
    @Getter
    @Setter
    private String content;

    @Column(name = "addDate")
    @Getter
    @Setter
    private LocalDate addDate;

    @Column(name = "category")
    @Getter
    @Setter
    private ECategory category;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "id")
    @Getter
    @Setter
    private User user;




}




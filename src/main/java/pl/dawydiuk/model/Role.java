package pl.dawydiuk.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Konrad on 30.10.2016.
 */
@Entity
@Table(name = "Role")
public class Role {

    @Id
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;

    @Column(name = "code")
    @Getter
    @Setter
    private String code;


    @Column(name = "label")
    @Getter
    @Setter
    private String label;

}

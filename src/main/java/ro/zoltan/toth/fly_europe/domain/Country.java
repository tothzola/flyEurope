package ro.zoltan.toth.fly_europe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter private long id;

    @Column(name = "code")
    @Getter @Setter private String code;

    @Column(name = "name")
    @Getter @Setter private String name;

    @Column(name = "wiki")
    @Getter @Setter private String wiki;

}

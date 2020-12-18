package ro.zoltan.toth.fly_europe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter private long id;

    @Column(name = "call_sign")
    @Getter @Setter private String callSign;

    @Column(name = "icao", length = 3)
    @Getter @Setter private String icao;

    @Column(name = "name")
    @Getter @Setter private String name;

    @ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    @Getter @Setter private Country country;

}

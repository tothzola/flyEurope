package ro.zoltan.toth.fly_europe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter private long id;

    @Column(name = "city")
    @Getter @Setter private String city;

    @Column(name = "iata", length = 3)
    @Getter @Setter private String iata;

    @Column(name = "icao", length = 4)
    @Getter @Setter private String icao;

    @Column(name = "map_url")
    @Getter @Setter private String mapUrl;

    @Column(name = "name")
    @Getter @Setter private String name;

    @ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    @Getter @Setter private Country country;

}

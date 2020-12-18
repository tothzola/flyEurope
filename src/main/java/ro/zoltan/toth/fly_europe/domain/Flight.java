package ro.zoltan.toth.fly_europe.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter @Setter private long id;

    @Column(name = "departure_time")
    @Getter @Setter private LocalDateTime departure;

    @Column(name = "arrival_time")
    @Getter @Setter private LocalDateTime arrival;

    @Column(name = "flight_no")
    @Getter @Setter private String flightNo;

    @ManyToOne(targetEntity = Airline.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id", nullable = false)
    @Getter @Setter private Airline airline;

    @ManyToOne(targetEntity = Airport.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "departure_airport_id", nullable = false)
    @Getter @Setter private Airport departureAirport;

    @ManyToOne(targetEntity = Airport.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    @Getter @Setter private Airport arrivalAirport;

    @ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false)
    @Getter @Setter private Country country;

}

package ro.zoltan.toth.fly_europe.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class Search {

    @Getter @Setter private LocalDateTime departureTime;
    @Getter @Setter private LocalDateTime arrivalTime;
    @Getter @Setter private String callSign;
    @Getter @Setter private String city;
    @Getter @Setter private String code;
    @Getter @Setter private String flightNo;
    @Getter @Setter private String iata;
    @Getter @Setter private String icao;
    @Getter @Setter private String mapUrl;
    @Getter @Setter private String name;

    public boolean hasCity() {
        return city != null && !city.isEmpty();
    }

    public boolean hasName() {
        return name != null && !name.isEmpty();
    }

}

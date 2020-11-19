package ro.zoltan.toth.fly_europe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.zoltan.toth.fly_europe.domain.Flight;
import ro.zoltan.toth.fly_europe.repository.FlightRepository;
import ro.zoltan.toth.fly_europe.service.FileService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightRepository airlineRepository;

    @Override
    public List<String> readContent(final String fileName) {
        final List<String> result = new ArrayList<>();
        try (InputStream is = (new URL(fileName)).openStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Flight> transformContent(final List<String> content) {
        return content.stream()
                .map(element -> transformElement(element))
                .collect(Collectors.toList());
    }

    private Flight transformElement(final String element) {
        final String[] parts = element.trim().replaceAll("\"", "").split(";");
        final Flight flight = new Flight();

//        @Column(name = "flight_no")
//        private String flightNo;
//
//        @ManyToOne(targetEntity = Airline.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//        @JoinColumn(name = "airline_id", nullable = false)
//        private Airline airline;
//
//        @ManyToOne(targetEntity = Airport.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//        @JoinColumn(name = "departure_airport_id", nullable = false)
//        private Airport departureAirport;
//
//        @ManyToOne(targetEntity = Airport.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//        @JoinColumn(name = "arrival_airport_id", nullable = false)
//        private Airport arrivalAirport;
//
//        @ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//        @JoinColumn(name = "country_id", nullable = false)
//        private Airline country;

        return flight;

   }

    @Override
    public boolean insertAll(List<Flight> flights) {
    return flightRepository.saveAll(flights).stream()
                .map(a -> a.getId() > 0)
                .reduce(true, (p, q) -> p && q);
    }

}

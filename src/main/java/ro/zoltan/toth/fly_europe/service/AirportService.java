package ro.zoltan.toth.fly_europe.service;

import org.springframework.data.domain.Page;
import ro.zoltan.toth.fly_europe.domain.Airport;
import ro.zoltan.toth.fly_europe.payload.AirportPayload;

public interface AirportService {

    Page<Airport> searchByCountry(int pageNum, String sortField, String sortDir, String keyword);

    Page<Airport> searchByNameAndCity(int pageNum, String sortField, String sortDir, String keyword);

    Page<Airport> listAll(int pageNum, String sortField, String sortDir);

    Airport createAirport(String name);

    Airport updateAirport(AirportPayload payload);

    void save(Airport product);

    Airport get(Long id);

    void delete(Long id);

}

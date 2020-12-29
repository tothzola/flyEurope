package ro.zoltan.toth.fly_europe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ro.zoltan.toth.fly_europe.domain.Airport;
import ro.zoltan.toth.fly_europe.payload.AirportPayload;
import ro.zoltan.toth.fly_europe.repository.AirportRepository;
import ro.zoltan.toth.fly_europe.service.AirportService;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

//    @Autowired
//    private CountryRepository countryRepository;

    @Override
    public Page<Airport> searchByCountry(int pageNum, String sortField, String sortDir, String keyword) {
        return null;
    }

    @Override
    public Page<Airport> searchByNameAndCity(int pageNum, String sortField, String sortDir, String keyword) {
        Pageable pageable = PageRequest.of(pageNum - 1, 10,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        return airportRepository.findAllByNameContainingOrCityContaining(keyword, keyword, pageable);
    }

    @Override
    public Page<Airport> listAll(int pageNum, String sortField, String sortDir) {
        Pageable pageable = PageRequest.of(pageNum - 1, 10,
                sortDir.equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
        return airportRepository.findAll(pageable);
    }

    @Override
    public Airport createAirport(final String name) {
        final Airport airport = new Airport();
        airport.setName(name);
        return  airportRepository.save(airport);
    }

    @Override
    public Airport updateAirport(final AirportPayload payload) {
        final Airport airport = new Airport();
        airport.setId(payload.getId());
        airport.setName(payload.getName());
        return airportRepository.save(airport);
    }

    @Override
    public void save(Airport airport) {
        airportRepository.save(airport);
    }

    @Override
    public Airport get(Long id) {
        return airportRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        airportRepository.deleteById(id);
    }
}

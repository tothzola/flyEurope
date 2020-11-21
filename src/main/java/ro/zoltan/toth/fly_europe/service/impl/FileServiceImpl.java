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
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<String> readContent(final String fileName) {
        final List<String> result = new ArrayList<>();
        try (InputStream is = (new URL(fileName)).openStream();
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result;
    }

    @Override
    public List<Flight> transformContent(final List<String> content) {
        return content.stream()
                .map(this::transformElement)
                .collect(Collectors.toList());
    }

    private Flight transformElement(final String element) {
        final String[] parts = element.trim().replaceAll("\"", "").split(";");
        final Flight flight = new Flight();
        return flight;

   }

    @Override
    public boolean insertAll(List<Flight> flights) {
    return flightRepository.saveAll(flights).stream()
                .map(a -> a.getId() > 0)
                .reduce(true, (p, q) -> p && q);
    }

}

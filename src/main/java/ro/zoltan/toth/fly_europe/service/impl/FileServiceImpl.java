package ro.zoltan.toth.fly_europe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.zoltan.toth.fly_europe.domain.Country;
import ro.zoltan.toth.fly_europe.repository.CountryRepository;
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
    private CountryRepository countryRepository;

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
    public List<Country> transformContent(final List<String> content) {
        return content.stream()
                .map(element -> transformElement(element))
                .collect(Collectors.toList());
    }

    private Country transformElement(final String element) {
        final String[] parts = element.trim().replaceAll("\"", "").split(";");
        final Country country = new Country();

//        airport.setName(parts[0]);
//        airport.setCity(parts[1]);
//        airport.setCountry(parts[2]);
//        airport.setIata(parts[3]);
//        airport.setIcao(parts[4]);
//        airport.setMapUrl(parts[5]);
//        return airport;

//        airline.setName(parts[0]);
//        airline.setIcao(parts[1]);
//        airline.setCallSign(parts[2]);
//        airline.setCountry(parts[3]);
//        return airline;

        country.setCode(parts[0]);
        country.setName(parts[1]);
        country.setWiki(parts[2]);

        return country;
   }

    @Override
    public boolean insertAll(List<Country> countries) {
    return countryRepository.saveAll(countries).stream()
                .map(a -> a.getId() > 0)
                .reduce(true, (p, q) -> p && q);
    }

}

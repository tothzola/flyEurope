package ro.zoltan.toth.fly_europe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.zoltan.toth.fly_europe.domain.Country;
import ro.zoltan.toth.fly_europe.repository.CountryRepository;
import ro.zoltan.toth.fly_europe.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public Country get(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}

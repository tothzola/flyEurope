package ro.zoltan.toth.fly_europe.service;

import ro.zoltan.toth.fly_europe.domain.Country;

public interface CountryService {

    void save(Country product);

    Country get(Long id);

    void delete(Long id);

}

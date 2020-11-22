package ro.zoltan.toth.fly_europe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.zoltan.toth.fly_europe.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {



}

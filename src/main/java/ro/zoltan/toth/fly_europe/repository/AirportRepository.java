package ro.zoltan.toth.fly_europe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.zoltan.toth.fly_europe.domain.Airport;

import java.util.List;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    @Query("SELECT a FROM Airport a WHERE CONCAT(a.name, ' ', a.country, ' ', a.city, ' ') LIKE %?1%")
    List<Airport> search(String keyword);

    Page<Airport> findAllByNameContainingOrCountryContainingOrCityContaining(String name, String country,
                                                                             String city, Pageable pageable);
}

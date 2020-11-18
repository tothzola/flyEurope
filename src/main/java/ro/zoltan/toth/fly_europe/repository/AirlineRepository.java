package ro.zoltan.toth.fly_europe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.zoltan.toth.fly_europe.domain.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

}

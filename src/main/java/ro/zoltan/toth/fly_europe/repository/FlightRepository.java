package ro.zoltan.toth.fly_europe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.zoltan.toth.fly_europe.domain.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}

package ro.zoltan.toth.fly_europe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.zoltan.toth.fly_europe.domain.Airline;

import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

    List<Airline> findById(int id);

}

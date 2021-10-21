package nl.rentmycar.Car;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface CarRepository extends CrudRepository<Car,Long>{

    Iterable<Car> findByBrandContaining(String brand);

//    Iterable<Car> findByAvailable(Trip trip);

    Iterable<Car> findByKmRateLessThanEqual(double kmrate);

    Iterable<Car> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(LocalDateTime startDateTime, LocalDateTime endDateTime);
}


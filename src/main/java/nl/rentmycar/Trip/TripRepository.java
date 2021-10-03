package nl.rentmycar.Trip;

import nl.rentmycar.Car.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository  extends CrudRepository<Trip, Long> {
}

package nl.rentmycar.Trip;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TripRepository  extends CrudRepository<Trip, Long> {
    Iterable<Trip> findByUser_Id(long id);
    Iterable<Trip> findByCar_Id(long id);
}

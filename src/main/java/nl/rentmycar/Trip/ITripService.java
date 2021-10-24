package nl.rentmycar.Trip;

import java.util.List;
import java.util.Optional;

public interface ITripService {
    List<Trip> findAll();

    List<Trip> findByUser_Id(long id);
    List<Trip> findByCar_Id(long id);
    Optional<Trip> findById(long id);
    void planTrip(Trip trip);
    void saveLocation(Trip trip);

    boolean saveAcceleration(Trip trip);
}

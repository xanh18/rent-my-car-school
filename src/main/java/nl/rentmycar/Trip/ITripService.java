package nl.rentmycar.Trip;

import java.util.List;
import java.util.Optional;

public interface ITripService {
    //Gets all trips.
    List<Trip> findAll();

    //Gets all trips bound to specific user by user_id.
    List<Trip> findByUser_Id(long id);

    //Gets all trips bound to specific car by car_id.
    List<Trip> findByCar_Id(long id);

    //Gets trip based on trip_id.
    Optional<Trip> findById(long id);

    //Plans a new trip. Trip has to include a user with a user_id and a car with a car_id, as well as a startDateTime and an endDateTime.
    void planTrip(Trip trip);

    void saveLocation(Trip trip);
    boolean saveAcceleration(Trip trip);
}

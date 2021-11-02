package nl.rentmycar.Car;
import nl.rentmycar.Trip.Trip;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface ICarService {
    //Gets all cars
    List<Car> findAll();

    //Gets all cars by carId
    Optional<Car> findById(long id);

    //Gets all cars by brand contains input
    List<Car> findByBrandContaining(String brand);

    //Gets cars whose are set to be available
    List<Car> findByAvailable(ArrayList<Trip> available);

    //Saves an instance of edits an instance of car
    void saveCar(Car car);

    //Gets cars by the max kmRate input of a user
    Iterable<Car> findByKmRateLessThanEqual(double kmrate);

    //Gets cars  available by certain time period
    Iterable<Car> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(Trip trip);  //This is where we started questioning our naming conventions.

    //Gets a car by userId
    Iterable<Car> findByUser_Id(long id);

    //Gets cars by the max startRate input of a user
    Iterable<Car> findByStartRateLessThanEqual(double startRate);
}


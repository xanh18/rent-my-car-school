package nl.rentmycar.Car;

import nl.rentmycar.Trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService{

    @Autowired
    private CarRepository repo;

    @Override
    public List<Car> findAll() {
        return (List<Car>) repo.findAll();
    }

    @Override
    public Optional<Car> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<Car> findByBrandContaining(String brand) {
        return (List<Car>) repo.findByBrandContaining(brand);
    }

    @Override
    public List<Car> findByAvailable(ArrayList<Trip> available) {
        return (List<Car>) repo.findAll();
    }

    @Override
    public boolean saveCar(Car car) {
        repo.save(car);
        return true;
    }

    @Override
    public Iterable<Car> findByKmRateLessThanEqual(double kmrate) {
        return repo.findByKmRateLessThanEqual(kmrate);
    }

    @Override
    public Iterable<Car> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(Trip trip) {

        return repo.findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(trip.getStartDateTime(), trip.getEndDateTime());
    }

    @Override
    public Iterable<Car> findByUser_Id(long id) {
        return repo.findByUser_Id(id);
    }

    @Override
    public Iterable<Car> findByStartRateLessThanEqual(double startRate) {
        return repo.findByStartRateLessThanEqual(startRate);
    }

}

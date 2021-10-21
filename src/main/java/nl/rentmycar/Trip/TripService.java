package nl.rentmycar.Trip;

import nl.rentmycar.Car.Car;
import nl.rentmycar.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TripService implements ITripService {

    @Autowired
    private TripRepository repo;

    @Override
    public List<Trip> findAll() {
        return (List<Trip>) repo.findAll();
    }

    @Override
    public List<Trip> findByUser_Id(long id) {
        return (List<Trip>) repo.findByUser_Id(id);
    }

    @Override
    public List<Trip> findByCar_Id(long id) {
        return (List<Trip>) repo.findByCar_Id(id);
    }

    @Override
    public Optional<Trip> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public void planTrip(Trip trip) {
        repo.save(trip);
    }

    @Override
    public void saveLocation(Trip tripInfo) {
        Trip trip = repo.findById(tripInfo.getId()).get();
        if(!trip.equals(tripInfo)){
            trip.addToLocations(tripInfo.getLocation());
        }
        repo.save(trip);
    }
}

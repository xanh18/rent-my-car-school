package nl.rentmycar.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TripService implements ITripService {

    @Autowired
    private TripRepository repo;

    public TripService(TripRepository repository) {
        this.repo = repository;
    }

    public TripService(){

    }

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
    public Trip planTrip(Trip trip) {
        return repo.save(trip);
    }

    @Override
    public void saveLocation(Trip tripInfo) {
        Optional<Trip> optional = repo.findById(tripInfo.getId());
        if(optional.isPresent()){
            Trip trip = optional.get();                  //Gets current Trip
            if(trip.getLocation() == null || trip.getLocation().isEmpty()){     //Checks if trip has a location, if not:
                trip.setLocation(tripInfo.getLocation());                       //Gives the trip a location.
                repo.save(trip);                                                //Saves trip
            } else if (!trip.equals(tripInfo)) {                                                           //Checks if car is standing still. If not:
                double x = Double.parseDouble(tripInfo.getLocation().split("\\s*[,]\\s*")[0]);      //Gets x coordinates of current location.
                double y = Double.parseDouble(tripInfo.getLocation().split("\\s*[,]\\s*")[1]);      //Gets y coordinates of current location.
                x = x - Double.parseDouble(trip.getLocation().split("\\s*[,]\\s*")[0]);             //Subtracts x coordinates of previous location from current.
                y = y - Double.parseDouble(trip.getLocation().split("\\s*[,]\\s*")[1]);             //Subtracts y coordinates of previous location from current.
                double xy = Math.sqrt((x * x) + (y * y));       //Calculates distance.
                trip.setDistance(trip.getDistance() + xy);      //Adds distance to Trip.distance.
                trip.setLocation(tripInfo.getLocation());       //Saves location to Trip.location.
                repo.save(trip);                                //Saves trip.
            }
        }
    }

    @Override
    public boolean saveAcceleration(Trip newAccel) {
        Optional<Trip> optional = repo.findById(newAccel.getId());
        if(optional.isPresent()) {
            Trip trip = optional.get();                              //Gets current Trip.
            boolean result = trip.getAcceleration().equals(newAccel.getAcceleration());    //Checks if user is driving well.
            trip.getAcceleration().setxAxis(newAccel.getAcceleration().getxAxis());         //Saves X axis speed.
            trip.getAcceleration().setyAxis(newAccel.getAcceleration().getyAxis());         //Saves Y axis speed.
            trip.getAcceleration().setzAxis(newAccel.getAcceleration().getzAxis());         //Saves Z axis speed.
            repo.save(trip);    //Saves trip.
            return result;      //returns whether the user is driving well. true = good, false = bad.
        }
        return false; //This is bad. Front end will read this as bad driving, when in actuality the trip was not found. Should never occur, but must still be fixed.
    }
}

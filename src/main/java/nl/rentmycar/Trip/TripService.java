package nl.rentmycar.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService implements ITripService {

    @Autowired
    private TripRepository repo;

    @Override
    public List<Trip> findAll() {
        return (List<Trip>) repo.findAll();
    }
}

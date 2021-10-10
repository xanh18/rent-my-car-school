package nl.rentmycar.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/trip")
public class TripController {

    @Autowired
    private ITripService tripService;

    @GetMapping()
    public List<Trip> getTrips() {
        List trips = (List<Trip>) tripService.findAll();
        return trips;
    }

}
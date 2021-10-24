package nl.rentmycar.Trip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/trip")
public class TripController {

    @Autowired
    private ITripService tripService;

    @GetMapping()
    public List<Trip> findAll() {
        return (List<Trip>) tripService.findAll();
    }

    @GetMapping(path = "/car/{id}")
    public List<Trip> findByUser_Id(@PathVariable long id) {
        return (List<Trip>) tripService.findByUser_Id(id);
    }

    @GetMapping(path = "/person/{id}")
    public List<Trip> findByCar_Id(@PathVariable long id) {
        return (List<Trip>) tripService.findByCar_Id(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Trip> findById(@PathVariable long id) {
        return tripService.findById(id);
    }

    @PostMapping(path = "/plan")
    public void planTrip(@Valid @RequestBody Trip trip) {
        tripService.planTrip(trip);
    }

    @PostMapping(path = "/location")
    public void saveLocation(@Valid @RequestBody Trip trip) {
        tripService.saveLocation(trip);
    }

    @PostMapping(path = "/acceleration")
    public boolean saveAcceleration(@Valid @RequestBody Trip trip){
        return tripService.saveAcceleration(trip);
    }
}
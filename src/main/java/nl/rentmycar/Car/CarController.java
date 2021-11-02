package nl.rentmycar.Car;

import nl.rentmycar.Trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/car") //baseline for all car endpoints. Always start with /car followed by the path of the endpoint.
public class CarController {

    @Autowired
    private ICarService carService;  //Auto wiring handles the initialization of the CarService class.

    @PostMapping(path = "/save") //saves a new car and also changes to an existing car
    public void saveCar(@Valid @RequestBody Car car){
        carService.saveCar(car);
    }

    @GetMapping()
    public List<Car> getCar() {
        return carService.findAll();
    }

    @GetMapping("/get/{id}") //find car by carId
    public Optional<Car> findById(@PathVariable long id)
    {
        return carService.findById(id);
    }

    @GetMapping("/brand/{brand}") // find cars by brand
    public List<Car> findByBrandContaining(@PathVariable String brand) {
        return carService.findByBrandContaining(brand);
    }

    @GetMapping(path = "/user/{id}") // find car by user id
    public List<Car> findByUser_Id(@PathVariable long id) {
        return (List<Car>) carService.findByUser_Id(id);
    }

    @GetMapping("/{car}/{available}") //find cars whose are set to be available
    public List<Car> findByAvailable(@PathVariable ArrayList<Trip> available) {return carService.findByAvailable(available);}

    @GetMapping("/search/kmrate/{kmrate}") //find cars by km rate
    public List<Car> findByKmRateLessThanEqual(@PathVariable double kmrate){
        return (List<Car>) carService.findByKmRateLessThanEqual(kmrate);
    }

    @PostMapping("/search/available") //find cars available by certain time period
        public List<Car> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(@Valid @RequestBody Trip trip){
        return (List<Car>) carService.findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(trip);
    }

    @GetMapping("/search/startRate/{startRate}") // find cars by startrate
    public List<Car> findByStartRateLessThanEqual(@PathVariable double startRate){
        return (List<Car>) carService.findByStartRateLessThanEqual(startRate);
    }

}
package nl.rentmycar.Car;

import nl.rentmycar.Trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private ICarService carService;

    @PostMapping(path = "/save")
    public void saveCar(@Valid @RequestBody Car car){
        carService.saveCar(car);
    }

    @GetMapping()
    public List<Car> getCar() {
        List cars = carService.findAll();
        return cars;
    }

    @GetMapping("/get/{id}")
    public Optional<Car> findById(@PathVariable long id)
    {
        return carService.findById(id);
    }

    @GetMapping("/brand/{brand}")
    public List<Car> findByBrandContaining(@PathVariable String brand)
    {
        return carService.findByBrandContaining(brand);
    }

    @GetMapping("/{car}/{available}")
    public List<Car> findByAvailable(@PathVariable ArrayList<Trip> available) {return carService.findByAvailable(available);}

    @GetMapping("/search/kmrate/{kmrate}")
    public List<Car> findByKmRateLessThanEqual(@PathVariable double kmrate){
        return (List<Car>) carService.findByKmRateLessThanEqual(kmrate);
    }

    @PostMapping("/search/available") //"endDateTime": "2015-02-05T12:59:11.332"
    public List<Car> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(@Valid @RequestBody Trip trip){
        return (List<Car>) carService.findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(trip);
    }

}
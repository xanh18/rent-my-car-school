package nl.rentmycar.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/api")

public class CarController {
    @Autowired
    private CarRepository repo;
    private ICarService carService;

    @GetMapping()
    public List<Car> getCar() {
        carService = new CarService(repo);
        List cars = (List<Car>) carService.findAll();
        return cars;
    }

}

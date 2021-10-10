package nl.rentmycar.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/car")
public class CarController {

    @Autowired
    private ICarService carService;

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

}

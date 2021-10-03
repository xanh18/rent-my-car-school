package nl.rentmycar.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class TestController {

    @Autowired
    private CarRepository repo;

    @GetMapping
    public Iterable<Car> getAll(@RequestParam(required = false) String brand)
    {
        if (brand == null) {
            return repo.findAll();
        }
        return repo.findCarByBrandContaining(brand);
    }
}

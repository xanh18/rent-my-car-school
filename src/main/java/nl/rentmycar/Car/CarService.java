package nl.rentmycar.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService{

    @Autowired
    private CarRepository repo;

    @Override
    public List<Car> findAll() {
        return (List<Car>) repo.findAll();
    }

    @Override
    public Optional<Car> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public List<Car> findByBrandContaining(String brand) {
        return (List<Car>) repo.findByBrandContaining(brand);
    }
}

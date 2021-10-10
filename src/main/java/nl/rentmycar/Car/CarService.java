package nl.rentmycar.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{

    @Autowired
    private CarRepository repo;

    @Override
    public List<Car> findAll() {
        return (List<Car>) repo.findAll();
    }
}

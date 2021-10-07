package nl.rentmycar.Car;

import org.springframework.stereotype.Repository;

import java.util.List;

public class CarService implements ICarService{

    private CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Car> findAll() {
        return (List<Car>) repo.findAll();
    }
}
